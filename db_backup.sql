create table BuildVersion
(
	SystemInformationID tinyint identity
		primary key,
	[Database Version] nvarchar(25) not null,
	VersionDate datetime not null,
	ModifiedDate datetime constraint DF_BuildVersion_ModifiedDate default getdate() not null
)
go

create table ErrorLog
(
	ErrorLogID int identity
		constraint PK_ErrorLog_ErrorLogID
			primary key,
	ErrorTime datetime constraint DF_ErrorLog_ErrorTime default getdate() not null,
	UserName sysname not null,
	ErrorNumber int not null,
	ErrorSeverity int,
	ErrorState int,
	ErrorProcedure nvarchar(126),
	ErrorLine int,
	ErrorMessage nvarchar(4000) not null
)
go

create table sberfood_account
(
	n_id bigint identity
		constraint sberfood_account_pk
			primary key nonclustered,
	c_login text not null,
	c_password text not null,
	b_payed bit not null,
	d_expire_date datetime
)
go

create unique index sberfood_account_n_id_uindex
	on sberfood_account (n_id)
go

create table sberfood_category
(
	n_id bigint identity
		constraint sberfood_category_pk
			primary key nonclustered,
	c_category_name text not null
)
go

create unique index sberfood_category_n_id_uindex
	on sberfood_category (n_id)
go

create table sberfood_product
(
	n_id bigint identity
		constraint sberfood_product_pk
			primary key nonclustered,
	c_name text not null,
	c_measure_type text not null
)
go

create unique index sberfood_product_n_id_uindex
	on sberfood_product (n_id)
go

create table sberfood_receipt
(
	n_id bigint identity
		constraint sberfood_receipts_pk
			primary key nonclustered,
	c_name text not null,
	c_description text not null,
	c_coocking_time text,
	n_calories bigint,
	n_category bigint,
	c_healthy text,
	n_view_count bigint default 0 not null
)
go

exec sp_addextendedproperty 'MS_Description', 'calories count in 100gramms', 'SCHEMA', 'dbo', 'TABLE', 'sberfood_receipt', 'COLUMN', 'n_calories'
go

create table sberfood_account_receipt
(
	n_account_id bigint not null
		constraint sberfood_account_receipt_sberfood_account_n_id_fk
			references sberfood_account,
	n_receipt_id bigint not null
		constraint sberfood_account_receipt_sberfood_receipt_n_id_fk
			references sberfood_receipt
)
go

create table sberfood_product_receipt
(
	n_receipt_id bigint not null
		constraint sberfood_products_in_receipt_sberfood_receipt_n_id_fk
			references sberfood_receipt,
	n_product_id bigint not null
		constraint sberfood_products_in_receipt_sberfood_product_n_id_fk
			references sberfood_product,
	n_product_count bigint not null
)
go

exec sp_addextendedproperty 'MS_Description', 'product count in receipt', 'SCHEMA', 'dbo', 'TABLE', 'sberfood_product_receipt', 'COLUMN', 'n_product_count'
go

create unique index sberfood_receipts_n_id_uindex
	on sberfood_receipt (n_id)
go

create table sberfood_receipt_category
(
	n_receipt_id bigint not null
		constraint sberfood_receipt_category_sberfood_receipt_n_id_fk
			references sberfood_receipt,
	n_category_id bigint not null
		constraint sberfood_receipt_category_sberfood_category_n_id_fk
			references sberfood_category
)
go

create table sysdiagrams
(
	name sysname not null,
	principal_id int not null,
	diagram_id int identity
		primary key,
	version int,
	definition varbinary(max),
	constraint UK_principal_name
		unique (principal_id, name)
)
go

