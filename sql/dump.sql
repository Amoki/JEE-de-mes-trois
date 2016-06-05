--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.1

-- Started on 2016-06-05 15:08:22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12360)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2138 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 26326)
-- Name: comments; Type: TABLE; Schema: public; Owner: jee
--

CREATE TABLE comments (
    id integer NOT NULL,
    rec_id integer,
    user_id integer,
    rating integer,
    content character varying(255),
    com_date timestamp without time zone
);


ALTER TABLE comments OWNER TO jee;

--
-- TOC entry 185 (class 1259 OID 26324)
-- Name: comments_id_seq; Type: SEQUENCE; Schema: public; Owner: jee
--

CREATE SEQUENCE comments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE comments_id_seq OWNER TO jee;

--
-- TOC entry 2139 (class 0 OID 0)
-- Dependencies: 185
-- Name: comments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: jee
--

ALTER SEQUENCE comments_id_seq OWNED BY comments.id;


--
-- TOC entry 184 (class 1259 OID 26315)
-- Name: recipes; Type: TABLE; Schema: public; Owner: jee
--

CREATE TABLE recipes (
    id integer NOT NULL,
    title character varying(255),
    description character varying(2048),
    summary character varying(255),
    type character varying(255),
    expertise integer,
    duration integer,
    nbpeople integer,
    img character varying(255)
);


ALTER TABLE recipes OWNER TO jee;

--
-- TOC entry 183 (class 1259 OID 26313)
-- Name: recipes_id_seq; Type: SEQUENCE; Schema: public; Owner: jee
--

CREATE SEQUENCE recipes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE recipes_id_seq OWNER TO jee;

--
-- TOC entry 2140 (class 0 OID 0)
-- Dependencies: 183
-- Name: recipes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: jee
--

ALTER SEQUENCE recipes_id_seq OWNED BY recipes.id;


--
-- TOC entry 182 (class 1259 OID 26302)
-- Name: users; Type: TABLE; Schema: public; Owner: jee
--

CREATE TABLE users (
    id integer NOT NULL,
    firstname character varying(255),
    lastname character varying(255),
    age integer,
    login character varying(255),
    pwd character varying(255),
    email character varying(255),
    admin boolean
);


ALTER TABLE users OWNER TO jee;

--
-- TOC entry 181 (class 1259 OID 26300)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: jee
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO jee;

--
-- TOC entry 2141 (class 0 OID 0)
-- Dependencies: 181
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: jee
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- TOC entry 2000 (class 2604 OID 26329)
-- Name: id; Type: DEFAULT; Schema: public; Owner: jee
--

ALTER TABLE ONLY comments ALTER COLUMN id SET DEFAULT nextval('comments_id_seq'::regclass);


--
-- TOC entry 1999 (class 2604 OID 26318)
-- Name: id; Type: DEFAULT; Schema: public; Owner: jee
--

ALTER TABLE ONLY recipes ALTER COLUMN id SET DEFAULT nextval('recipes_id_seq'::regclass);


--
-- TOC entry 1998 (class 2604 OID 26305)
-- Name: id; Type: DEFAULT; Schema: public; Owner: jee
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- TOC entry 2130 (class 0 OID 26326)
-- Dependencies: 186
-- Data for Name: comments; Type: TABLE DATA; Schema: public; Owner: jee
--

COPY comments (id, rec_id, user_id, rating, content, com_date) FROM stdin;
\.


--
-- TOC entry 2142 (class 0 OID 0)
-- Dependencies: 185
-- Name: comments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: jee
--

SELECT pg_catalog.setval('comments_id_seq', 1, false);


--
-- TOC entry 2128 (class 0 OID 26315)
-- Dependencies: 184
-- Data for Name: recipes; Type: TABLE DATA; Schema: public; Owner: jee
--

COPY recipes (id, title, description, summary, type, expertise, duration, nbpeople, img) FROM stdin;
1	Omelette	Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui IN ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur.	Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed DO eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.	Repas chaud	2	6	1	omlette.png
2	Meringue Itelaienne	Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui IN ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur.	Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed DO eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.	Dessert	10	25	6	meringue.png
3	Salade Niçoise	Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui IN ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur.	Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed DO eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.	Salade	3	10	2	salade.png
4	a	a	\N	Pastas	0	10	20	\N
\.


--
-- TOC entry 2143 (class 0 OID 0)
-- Dependencies: 183
-- Name: recipes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: jee
--

SELECT pg_catalog.setval('recipes_id_seq', 4, true);


--
-- TOC entry 2126 (class 0 OID 26302)
-- Dependencies: 182
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: jee
--

COPY users (id, firstname, lastname, age, login, pwd, email, admin) FROM stdin;
1	Adrien	REDON	20	aredon	P@ssw0rd	yolo@yolo.fr	t
2	Hugo	DUROUX	24	amoki	P@ssw0rd	yolo@yolo.fr	t
3	Nicolas	LEBRUN	20	beudy	P@ssw0rd	yolo@yolo.fr	t
4	Not	ADMIN	20	notadmin	P@ssw0rd	yolo@yolo.fr	t
\.


--
-- TOC entry 2144 (class 0 OID 0)
-- Dependencies: 181
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: jee
--

SELECT pg_catalog.setval('users_id_seq', 1, false);


--
-- TOC entry 2008 (class 2606 OID 26331)
-- Name: comments_pkey; Type: CONSTRAINT; Schema: public; Owner: jee
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_pkey PRIMARY KEY (id);


--
-- TOC entry 2006 (class 2606 OID 26323)
-- Name: recipes_pkey; Type: CONSTRAINT; Schema: public; Owner: jee
--

ALTER TABLE ONLY recipes
    ADD CONSTRAINT recipes_pkey PRIMARY KEY (id);


--
-- TOC entry 2002 (class 2606 OID 26312)
-- Name: users_login_key; Type: CONSTRAINT; Schema: public; Owner: jee
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_login_key UNIQUE (login);


--
-- TOC entry 2004 (class 2606 OID 26310)
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: jee
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2009 (class 2606 OID 26332)
-- Name: comments_rec_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: jee
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_rec_id_fkey FOREIGN KEY (rec_id) REFERENCES recipes(id);


--
-- TOC entry 2010 (class 2606 OID 26337)
-- Name: comments_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: jee
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 2137 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-06-05 15:08:23

--
-- PostgreSQL database dump complete
--

