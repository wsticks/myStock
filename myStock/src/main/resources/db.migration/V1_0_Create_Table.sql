
  /*create Token table */
- CREATE TABLE token(
 	   id bigint PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    "user" varchar(32)  NULL REFERENCES "user" (unique_key),
    token varchar(64)  NULL,
    status varchar(16)  NULL,
    created_at timestamp  NOT NULL,
    updated_at timestamp NULL,
    expires_at timestamp NULL
  );

  /*create Role permission table */
  CREATE TABLE role_permission(
 	   id bigint PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    role_id bigint  NOT NULL REFERENCES role (id),
    permission_id bigint  NOT NULL REFERENCES permission (id),
    status varchar(16)  NOT NULL,
    created_at timestamp  NOT NULL,
    updated_at timestamp NULL,
 );

 /* Generate auto id for postgre*/

 /*create Role table */
   CREATE TABLE role (
   id SERIAL NOT NULL,
    unique_key varchar(32)  NOT NULL,
     name varchar(128)  NOT NULL,
     description varchar(525)  NOT NULL,
    status varchar(16)  NULL,
     created_at timestamp  NOT NULL,
    updated_at timestamp NULL,
    is_hidden varchar(16)  NOT NULL,
    UNIQUE(unique_key),
 	  PRIMARY KEY (id)
  );


 /*create Stock table */
   CREATE TABLE stock (
   id SERIAL NOT NULL,
    unique_key varchar(32)  NOT NULL,
     first_stock varchar(525)  NOT NULL,
     second_stock varchar(525)  NOT NULL,
    third_stock varchar(525)  NULL,
    fourth_stock varchar(525)
    created_at timestamp  NOT NULL,
    updated_at timestamp NULL,
    is_hidden varchar(16)  NOT NULL,
    UNIQUE(unique_key),
 	  PRIMARY KEY (id)
  );

   CREATE TABLE "user"(
   id SERIAL(1, 1)  NOT NULL,
   unique_key varchar(32)  NOT NULL,
   first_name varchar(255)  NULL,
   last_name varchar(255)  NULL ,
   email varchar(255)  NULL,
   "password" varchar(255)  NULL,
   phone varchar(16)  NULL,
   "address" text  NULL,
   role_id VARCHAR(32)  NOT NULL REFERENCES  role (unique_key),
   status varchar(16)  NOT NULL,
   last_login_date varchar(50)  NULL,
   created_at timestamp  NOT NULL,
   updated_at timestamp NULL,
   PRIMARY KEY (unique_key)
 );