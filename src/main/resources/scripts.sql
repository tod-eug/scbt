CREATE TABLE public.users (
    id uuid NOT NULL,
	tg_id varchar(30) NOT NULL,
	chat_id varchar(30) NOT NULL,
	user_name varchar(100) NULL,
	first_name varchar(100) NULL,
	last_name varchar(100) NULL,
	is_bot bool NOT NULL,
	language_code varchar(10) NULL,
	create_date timestamp NOT NULL,
	CONSTRAINT users_pkey PRIMARY KEY (tg_id)
);

CREATE TABLE public.analytics (
	id uuid NOT NULL,
	user_id varchar(30) NOT NULL,
	command varchar(30) NULL,
	message_id varchar(30) NULL,
	text varchar(3000) NULL,
	callback varchar(100) NULL,
	create_date timestamp NOT NULL,
	CONSTRAINT analytics_pkey PRIMARY KEY (id)
);

CREATE TABLE public.cafes (
	id uuid NOT NULL,
	name varchar(100) NOT NULL,
	address varchar(100) NULL,
	district varchar(30) NULL,
	contact varchar(100) NULL,
	info varchar(3000) NULL,
	create_date timestamp NOT NULL,
	CONSTRAINT cafes_pkey PRIMARY KEY (id)
);

CREATE TABLE public.cafes_availability (
	id uuid NOT NULL,
	cafe_id uuid NOT NULL,
	day_of_week varchar(100) NULL,
	start_time timestamp NULL,
	end_time timestamp NULL,
	timing varchar(50) NULL,
	create_date timestamp NOT NULL,
	CONSTRAINT cafes_availability_pkey PRIMARY KEY (id)
);