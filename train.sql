--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0
-- Dumped by pg_dump version 14.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: train; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.train (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    route character varying(50) NOT NULL
);


ALTER TABLE public.train OWNER TO postgres;

--
-- Name: train_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.train_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.train_id_seq OWNER TO postgres;

--
-- Name: train_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.train_id_seq OWNED BY public.train.id;


--
-- Name: waypoint; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.waypoint (
    id integer NOT NULL,
    station character varying(50) NOT NULL,
    arrivaltime time without time zone NOT NULL,
    departuretime time without time zone NOT NULL
);


ALTER TABLE public.waypoint OWNER TO postgres;

--
-- Name: waypoint_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.waypoint_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.waypoint_id_seq OWNER TO postgres;

--
-- Name: waypoint_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.waypoint_id_seq OWNED BY public.waypoint.id;


--
-- Name: waypoint_train; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.waypoint_train (
    id_waypoint integer NOT NULL,
    id_train integer NOT NULL,
    number integer NOT NULL
);


ALTER TABLE public.waypoint_train OWNER TO postgres;

--
-- Name: train id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.train ALTER COLUMN id SET DEFAULT nextval('public.train_id_seq'::regclass);


--
-- Name: waypoint id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.waypoint ALTER COLUMN id SET DEFAULT nextval('public.waypoint_id_seq'::regclass);


--
-- Data for Name: train; Type: TABLE DATA; Schema: public; Owner: postgres
--


SELECT pg_catalog.setval('public.train_id_seq', 32, true);


--
-- Name: waypoint_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.waypoint_id_seq', 10, true);


--
-- Name: train train_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.train
    ADD CONSTRAINT train_name_key UNIQUE (name);


--
-- Name: train train_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.train
    ADD CONSTRAINT train_pkey PRIMARY KEY (id);


--
-- Name: waypoint waypoint_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.waypoint
    ADD CONSTRAINT waypoint_pkey PRIMARY KEY (id);


--
-- Name: waypoint_train waypoint_train_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.waypoint_train
    ADD CONSTRAINT waypoint_train_pkey PRIMARY KEY (id_waypoint, id_train, number);


--
-- Name: waypoint_train fk_id_train; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.waypoint_train
    ADD CONSTRAINT fk_id_train FOREIGN KEY (id_train) REFERENCES public.train(id);


--
-- Name: waypoint_train fk_id_waypoint; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.waypoint_train
    ADD CONSTRAINT fk_id_waypoint FOREIGN KEY (id_waypoint) REFERENCES public.waypoint(id);


--
-- PostgreSQL database dump complete
--

