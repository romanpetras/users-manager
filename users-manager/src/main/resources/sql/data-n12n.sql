insert into usersmgr.roles (code, description, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
VALUES ('SUPPORT', 'Support', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.roles (code, description, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
VALUES ('TERMINAL', 'Terminal', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.roles (code, description, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
VALUES ('SHIPPER', 'Trasportatore', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.companies (code, name, vat_number, vat_country_code, enabled, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('CIRCLE', 'Circle S.p.A.', '07869320965', 'IT', '1', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.companies (code, name, vat_number, vat_country_code, enabled, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('TEST_C_1', 'Test Company 1', '1', 'IT', '1', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.companies (code, name, vat_number, vat_country_code, enabled, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('TEST_C_2', 'Test Company 2', '2', 'IT', '1', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.companies (code, name, vat_number, vat_country_code, enabled, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('TEST_C_3', 'Test Company 3', '3', 'IT', '1', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.companies (code, name, vat_number, vat_country_code, enabled, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('TEST_C_4', 'Test Company 4', '4', 'IT', '1', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.companies_roles (company_id, role_id, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ((select id from usersmgr.companies where code='CIRCLE'), (select id from usersmgr.roles where code='SUPPORT'), now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.companies_roles (company_id, role_id, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ((select id from usersmgr.companies where code='TEST_C_1'), (select id from usersmgr.roles where code='TERMINAL'),now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.companies_roles (company_id, role_id, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ((select id from usersmgr.companies where code='TEST_C_2'), (select id from usersmgr.roles where code='TERMINAL'), now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.companies_roles (company_id, role_id, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ((select id from usersmgr.companies where code='TEST_C_3'), (select id from usersmgr.roles where code='SHIPPER'), now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.companies_roles (company_id, role_id, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ((select id from usersmgr.companies where code='TEST_C_4'), (select id from usersmgr.roles where code='SHIPPER'), now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.groups (code, description, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('ADMIN', 'Amministratore', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.groups (code, description, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('USER', 'Utente', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.groups (code, description, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('GUEST_USER', 'Utente guest', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.groups (code, description, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('GUEST_ADMIN', 'Amministratore guest', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.users (username, password_hash, password_hash_alg, last_name, first_name, email, company_id, enabled, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('admin', md5('circle1423'), 'MD5', 'Admin', 'Admin', 'support@circletouch.eu', (select id from usersmgr.companies where code='CIRCLE'), '1', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.users (username, password_hash, password_hash_alg, last_name, first_name, email, company_id, enabled, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('term1', md5('term1'), 'MD5', 'Terminal 1', 'Utente1', 'support@circletouch.eu', (select id from usersmgr.companies where code='TEST_C_1'), '1', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.users (username, password_hash, password_hash_alg, last_name, first_name, email, company_id, enabled, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('term2', md5('term2'), 'MD5', 'Terminal 1', 'Utente2', 'support@circletouch.eu', (select id from usersmgr.companies where code='TEST_C_1'), '1', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.users (username, password_hash, password_hash_alg, last_name, first_name, email, company_id, enabled, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('term3', md5('term3'), 'MD5', 'Terminal 2', 'Utente1', 'support@circletouch.eu', (select id from usersmgr.companies where code='TEST_C_2'), '1', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.users (username, password_hash, password_hash_alg, last_name, first_name, email, company_id, enabled, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('term4', md5('term4'), 'MD5', 'Terminal 2', 'Utente2', 'support@circletouch.eu', (select id from usersmgr.companies where code='TEST_C_2'), '1', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.users (username, password_hash, password_hash_alg, last_name, first_name, email, company_id, enabled, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('trasp1', md5('trasp1'), 'MD5', 'Trasportatore 1', 'Utente1', 'support@circletouch.eu', (select id from usersmgr.companies where code='TEST_C_3'), '1', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.users (username, password_hash, password_hash_alg, last_name, first_name, email, company_id, enabled, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('trasp2', md5('trasp2'), 'MD5', 'Trasportatore 1', 'Utente2', 'support@circletouch.eu', (select id from usersmgr.companies where code='TEST_C_3'), '1', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.users (username, password_hash, password_hash_alg, last_name, first_name, email, company_id, enabled, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('trasp3', md5('trasp3'), 'MD5', 'Trasportatore 2', 'Utente1', 'support@circletouch.eu', (select id from usersmgr.companies where code='TEST_C_4'), '1', now(), '1', 'admin', now(), 1, 'admin');

insert into usersmgr.users (username, password_hash, password_hash_alg, last_name, first_name, email, company_id, enabled, create_timestamp, create_user_id, create_user, update_timestamp, update_user_id, update_user)
values ('trasp4', md5('trasp4'), 'MD5', 'Trasportatore 3', 'Utente2', 'support@circletouch.eu', (select id from usersmgr.companies where code='TEST_C_4'), '1', now(), '1', 'admin', now(), 1, 'admin');
