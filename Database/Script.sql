-- CREATE DATABASE
CREATE DATABASE qphpractice WITH OWNER postgres;

-- CREATE SCHEMA
CREATE SCHEMA IF NOT EXISTS qph_practice_billing AUTHORIZATION postgres;
COMMENT ON SCHEMA qph_practice_billing IS 'Schema for billing related data with authorization set to postgres'

-- CREATE SEQUENCES
CREATE SEQUENCE qph_practice_billing.qph_customer_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
COMMENT ON SEQUENCE qph_practice_billing.qph_customer_seq IS 'Customer sequence';

CREATE SEQUENCE qph_practice_billing.qph_product_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
COMMENT ON SEQUENCE qph_practice_billing.qph_product_seq IS 'Product sequence';

CREATE SEQUENCE qph_practice_billing.qph_supplier_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
COMMENT ON SEQUENCE qph_practice_billing.qph_supplier_seq IS 'Supplier sequence';

CREATE SEQUENCE qph_practice_billing.qph_invoice_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
COMMENT ON SEQUENCE qph_practice_billing.qph_invoice_seq IS 'Invoice sequence';

CREATE SEQUENCE qph_practice_billing.qph_invoice_product_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
COMMENT ON SEQUENCE qph_practice_billing.qph_invoice_product_seq IS 'Invoice product sequence';

-- CREATE TABLES
--- CREATE qph_customer table
CREATE TABLE qph_practice_billing.qph_customer (
	customer_id int4 DEFAULT nextval('qph_practice_billing.qph_customer_seq'::regclass) NOT NULL,
	identity_id int4 NOT NULL,
	name varchar(200) NOT NULL,
	last_name varchar(200) NOT NULL,
	phone_number int4 NOT NULL,
	address varchar(800) NULL,
	creation_date timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
	update_date timestamp NULL
);

COMMENT ON COLUMN qph_practice_billing.qph_customer.customer_id IS 'Customer primary key';
COMMENT ON COLUMN qph_practice_billing.qph_customer.identity_id IS 'Customer unique identifier';
COMMENT ON COLUMN qph_practice_billing.qph_customer.name IS 'Customer name';
COMMENT ON COLUMN qph_practice_billing.qph_customer.last_name IS 'Customer last name';
COMMENT ON COLUMN qph_practice_billing.qph_customer.phone_number IS 'Customer phone number';
COMMENT ON COLUMN qph_practice_billing.qph_customer.address IS 'Customer address';
COMMENT ON COLUMN qph_practice_billing.qph_customer.creation_date IS 'Customer creation date';
COMMENT ON COLUMN qph_practice_billing.qph_customer.update_date IS 'Customer update date';

ALTER TABLE qph_practice_billing.qph_customer ADD CONSTRAINT customer_pk PRIMARY KEY (customer_id);
ALTER TABLE qph_practice_billing.qph_customer ADD CONSTRAINT customer_identity_id_uq UNIQUE (identity_id);

--- CREATE qph_supplier table
CREATE TABLE qph_practice_billing.qph_supplier (
	supplier_id int4 DEFAULT nextval('qph_practice_billing.qph_supplier_seq'::regclass) NOT NULL,
	ruc int4 NOT NULL,
	name varchar(200) NOT NULL,
	phone_number int4 NOT NULL,
	address varchar(800) NULL,
	creation_date timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
	update_date timestamp NULL
);

COMMENT ON COLUMN qph_practice_billing.qph_supplier.supplier_id IS 'Supplier primary key';
COMMENT ON COLUMN qph_practice_billing.qph_supplier.ruc IS 'Supplier ruc';
COMMENT ON COLUMN qph_practice_billing.qph_supplier.name IS 'Supplier name';
COMMENT ON COLUMN qph_practice_billing.qph_supplier.phone_number IS 'Supplier phone number';
COMMENT ON COLUMN qph_practice_billing.qph_supplier.address IS 'Supplier address';
COMMENT ON COLUMN qph_practice_billing.qph_supplier.creation_date IS 'Supplier creation date';
COMMENT ON COLUMN qph_practice_billing.qph_supplier.update_date IS 'Supplier update date';

ALTER TABLE qph_practice_billing.qph_supplier ADD CONSTRAINT supplier_pk PRIMARY KEY (supplier_id);
ALTER TABLE qph_practice_billing.qph_supplier ADD CONSTRAINT supplier_ruc_uq UNIQUE (ruc);

--- CREATE qph_product table
CREATE TABLE qph_practice_billing.qph_product (
	product_id int4 DEFAULT nextval('qph_practice_billing.qph_product_seq'::regclass) NOT NULL,
	bar_code int4 NOT NULL,
	name varchar(200) NOT NULL,
	price decimal(10, 2) NOT NULL,
	description varchar(800) NULL,
	creation_date timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
	update_date timestamp NULL
);

COMMENT ON COLUMN qph_practice_billing.qph_product.product_id IS 'Product primary key';
COMMENT ON COLUMN qph_practice_billing.qph_product.bar_code IS 'Product bar code';
COMMENT ON COLUMN qph_practice_billing.qph_product.name IS 'Product name';
COMMENT ON COLUMN qph_practice_billing.qph_product.price IS 'Product price';
COMMENT ON COLUMN qph_practice_billing.qph_product.description IS 'Product description';
COMMENT ON COLUMN qph_practice_billing.qph_product.creation_date IS 'Product creation date';
COMMENT ON COLUMN qph_practice_billing.qph_product.update_date IS 'Product update date';

ALTER TABLE qph_practice_billing.qph_product ADD CONSTRAINT product_pk PRIMARY KEY (product_id);
ALTER TABLE qph_practice_billing.qph_product ADD CONSTRAINT product_bar_code_uq UNIQUE (bar_code);

--- CREATE qph_invoice table
CREATE TABLE qph_practice_billing.qph_invoice (
	invoice_id int4 DEFAULT nextval('qph_practice_billing.qph_invoice_seq'::regclass) NOT NULL,
	invoice_number int4 NOT NULL,
	supplier_id_qph_supplier int4 NOT NULL,
	customer_id_qph_customer int4 NOT NULL,
	total_price decimal(10, 2) NOT NULL,
	creation_date timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
	update_date timestamp NULL
);

COMMENT ON COLUMN qph_practice_billing.qph_invoice.invoice_id IS 'Invoice primary key';
COMMENT ON COLUMN qph_practice_billing.qph_invoice.invoice_number IS 'Invoice number';
COMMENT ON COLUMN qph_practice_billing.qph_invoice.supplier_id_qph_supplier IS 'Invoice supplier id (FK)';
COMMENT ON COLUMN qph_practice_billing.qph_invoice.customer_id_qph_customer IS 'Invoice customer id (FK)';
COMMENT ON COLUMN qph_practice_billing.qph_invoice.total_price IS 'Invoice total price';
COMMENT ON COLUMN qph_practice_billing.qph_invoice.creation_date IS 'Invoice creation date';
COMMENT ON COLUMN qph_practice_billing.qph_invoice.update_date IS 'Invoice update date';

ALTER TABLE qph_practice_billing.qph_invoice ADD CONSTRAINT invoice_pk PRIMARY KEY (invoice_id);
ALTER TABLE qph_practice_billing.qph_invoice ADD CONSTRAINT invoice_number_uq UNIQUE (invoice_number);
ALTER TABLE qph_practice_billing.qph_invoice ADD CONSTRAINT invoice_supplier_fk FOREIGN KEY (supplier_id_qph_supplier) REFERENCES qph_practice_billing.qph_supplier(supplier_id);
ALTER TABLE qph_practice_billing.qph_invoice ADD CONSTRAINT invoice_customer_fk FOREIGN KEY (customer_id_qph_customer) REFERENCES qph_practice_billing.qph_customer(customer_id);

--- CREATE qph_invoice_product table
CREATE TABLE qph_practice_billing.qph_invoice_product (
	invoice_product_id int4 DEFAULT nextval('qph_practice_billing.qph_invoice_product_seq'::regclass) NOT NULL,
	invoice_id_qph_invoice int4 NOT NULL,
	product_id_qph_product int4 NOT NULL,
	creation_date timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
	update_date timestamp NULL
);

COMMENT ON COLUMN qph_practice_billing.qph_invoice_product.invoice_product_id IS 'Invoice_product primary key';
COMMENT ON COLUMN qph_practice_billing.qph_invoice_product.invoice_id_qph_invoice IS 'Invoice_product invoice number (FK)';
COMMENT ON COLUMN qph_practice_billing.qph_invoice_product.product_id_qph_product IS 'Invoice_product product id (FK)';
COMMENT ON COLUMN qph_practice_billing.qph_invoice_product.creation_date IS 'Invoice_product creation date';
COMMENT ON COLUMN qph_practice_billing.qph_invoice_product.update_date IS 'Invoice_product update date';

ALTER TABLE qph_practice_billing.qph_invoice_product ADD CONSTRAINT invoice_product_pk PRIMARY KEY (invoice_product_id);
ALTER TABLE qph_practice_billing.qph_invoice_product ADD CONSTRAINT invoice_product_invoice_fk FOREIGN KEY (invoice_id_qph_invoice) REFERENCES qph_practice_billing.qph_invoice(invoice_id);
ALTER TABLE qph_practice_billing.qph_invoice_product ADD CONSTRAINT invoice_product_product_fk FOREIGN KEY (product_id_qph_product) REFERENCES qph_practice_billing.qph_product(product_id);
