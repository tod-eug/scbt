CREATE TABLE public.users (
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
	text varchar(3000) NULL,
	callback varchar(100) NULL,
	create_date timestamp NOT NULL,
	CONSTRAINT analytics_pkey PRIMARY KEY (id)
);