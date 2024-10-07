INSERT INTO qph_practice_billing.qph_customer
(identity_id, "name", last_name, phone_number, address)
VALUES(5466, 'Jose', 'Velez', 926378233, 'Cotocollao');

INSERT INTO qph_practice_billing.qph_supplier
(ruc, "name", phone_number, address)
VALUES(2134344, 'Bodegas S.A', 667654455, 'Condado');

INSERT INTO qph_practice_billing.qph_invoice
(invoice_number, supplier_id_qph_supplier, customer_id_qph_customer, total_price)
VALUES
	(67555, (
		SELECT
			supplier_id
		FROM
			qph_practice_billing.qph_supplier
		WHERE
			ruc = 2134344
	), 
	(
		SELECT
			customer_id
		FROM
			qph_practice_billing.qph_customer
		WHERE
			identity_id = 5466
	), 145.21);

INSERT INTO qph_practice_billing.qph_product
(bar_code, "name", price, description)
VALUES(47832877, 'Sabanas', 29.78, 'Sabanas grandes');

INSERT INTO qph_practice_billing.qph_invoice_product
(invoice_id_qph_invoice, product_id_qph_product)
VALUES
	((
		SELECT
			invoice_id
		FROM
			qph_practice_billing.qph_invoice
		WHERE
			invoice_number = 67555
	),
	(
		SELECT
			product_id
		FROM
			qph_practice_billing.qph_product
		WHERE
			bar_code = 47832877
	));