--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.7
-- Dumped by pg_dump version 9.6.7

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: chart_of_account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE chart_of_account (
    id bigint NOT NULL,
    deleted character(1) NOT NULL
);


ALTER TABLE chart_of_account OWNER TO postgres;

--
-- Name: company; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE company (
    id bigint NOT NULL,
    deleted character(1) NOT NULL,
    is_group character(1),
    incorporation_date timestamp without time zone,
    company_name character varying(255),
    reporting_period_end_day integer,
    reporting_period_end_month integer,
    tin character varying(255),
    company_type character varying(255)
);


ALTER TABLE company OWNER TO postgres;

--
-- Name: corporate_information; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE corporate_information (
    id bigint NOT NULL,
    company_name character varying(255),
    current_year integer,
    group_of_entities character(1),
    incorporation_date timestamp without time zone,
    prior_year integer,
    reporting_date_current_year timestamp without time zone,
    reporting_date_prior_year timestamp without time zone,
    reporting_entity_a_branch character(1)
);


ALTER TABLE corporate_information OWNER TO postgres;

--
-- Name: enumeration_answers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE enumeration_answers (
    question_answer_pair_id bigint NOT NULL,
    enumeration_answers character varying(255),
    idx integer NOT NULL
);


ALTER TABLE enumeration_answers OWNER TO postgres;

--
-- Name: fs_level_1; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE fs_level_1 (
    id bigint NOT NULL,
    deleted character(1) NOT NULL,
    description text,
    name character varying(255) NOT NULL,
    coa_id bigint
);


ALTER TABLE fs_level_1 OWNER TO postgres;

--
-- Name: fs_level_2; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE fs_level_2 (
    id bigint NOT NULL,
    deleted character(1) NOT NULL,
    description text,
    name character varying(255) NOT NULL,
    parent_id bigint
);


ALTER TABLE fs_level_2 OWNER TO postgres;

--
-- Name: fs_level_3; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE fs_level_3 (
    id bigint NOT NULL,
    deleted character(1) NOT NULL,
    description text,
    name character varying(255) NOT NULL,
    parent_id bigint
);


ALTER TABLE fs_level_3 OWNER TO postgres;

--
-- Name: fs_level_4; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE fs_level_4 (
    id bigint NOT NULL,
    deleted character(1) NOT NULL,
    acct_no character varying(255) NOT NULL,
    description text,
    name character varying(255) NOT NULL,
    parent_id bigint
);


ALTER TABLE fs_level_4 OWNER TO postgres;

--
-- Name: fs_level_5; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE fs_level_5 (
    id bigint NOT NULL,
    deleted character(1) NOT NULL,
    acct_no character varying(255) NOT NULL,
    description text,
    name character varying(255) NOT NULL,
    parent_id bigint
);


ALTER TABLE fs_level_5 OWNER TO postgres;

--
-- Name: fs_level_6; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE fs_level_6 (
    id bigint NOT NULL,
    deleted character(1) NOT NULL,
    acct_no character varying(255) NOT NULL,
    code character varying(255),
    curr_yr numeric(19,2) NOT NULL,
    description character varying(255),
    name character varying(255) NOT NULL,
    prev_yr numeric(19,2) NOT NULL,
    parent_id bigint
);


ALTER TABLE fs_level_6 OWNER TO postgres;

--
-- Name: gpfs; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE gpfs (
    id bigint NOT NULL,
    deleted character(1) NOT NULL,
    next_state character varying(255),
    year integer NOT NULL,
    coa_id bigint,
    company_id bigint NOT NULL,
    pa_id bigint,
    reconciliation_id bigint
);


ALTER TABLE gpfs OWNER TO postgres;

--
-- Name: gpfs_note; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE gpfs_note (
    id bigint NOT NULL,
    deleted character(1) NOT NULL,
    note_idx integer NOT NULL,
    gpfs_id bigint
);


ALTER TABLE gpfs_note OWNER TO postgres;

--
-- Name: gpfs_schedule; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE gpfs_schedule (
    id bigint NOT NULL,
    deleted character(1) NOT NULL,
    schedule_index integer NOT NULL,
    gpfs_id bigint,
    index integer
);


ALTER TABLE gpfs_schedule OWNER TO postgres;

--
-- Name: gpfs_schedule_cells; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE gpfs_schedule_cells (
    gpfs_schedule_rows_id bigint NOT NULL,
    comment character varying(255),
    content character varying(255),
    formula character varying(255),
    col_idx integer NOT NULL
);


ALTER TABLE gpfs_schedule_cells OWNER TO postgres;

--
-- Name: gpfs_schedule_rows; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE gpfs_schedule_rows (
    id bigint NOT NULL,
    deleted character(1) NOT NULL,
    schedule_id bigint,
    row_idx integer
);


ALTER TABLE gpfs_schedule_rows OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hibernate_sequence OWNER TO postgres;

--
-- Name: question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE question (
    id bigint NOT NULL,
    deleted character(1) NOT NULL,
    act_condition character varying(255),
    help_text text,
    max_answers integer,
    next_paragraph character(1) NOT NULL,
    no_template character varying(255),
    note integer NOT NULL,
    question text,
    sample_answer text,
    section_reference character varying(255),
    series integer,
    template text,
    type character varying(255)
);


ALTER TABLE question OWNER TO postgres;

--
-- Name: question_answer_pair; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE question_answer_pair (
    id bigint NOT NULL,
    deleted character(1) NOT NULL,
    activated character(1),
    answer character varying(255),
    edit_template_mode character(1),
    template text,
    question_id bigint,
    note_id bigint
);


ALTER TABLE question_answer_pair OWNER TO postgres;

--
-- Name: question_mc_answers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE question_mc_answers (
    question_id bigint NOT NULL,
    answer text,
    help_text text,
    template text
);


ALTER TABLE question_mc_answers OWNER TO postgres;

--
-- Name: reconciliation_table; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE reconciliation_table (
    id bigint NOT NULL,
    coc_fd numeric(19,2),
    coc_ld numeric(19,2),
    total_equity_fd numeric(19,2),
    total_equity_ld numeric(19,2)
);


ALTER TABLE reconciliation_table OWNER TO postgres;

--
-- Name: ref_principal_activity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE ref_principal_activity (
    id bigint NOT NULL,
    deleted character(1) NOT NULL,
    activity character varying(255),
    subtype character varying(255),
    type character varying(255)
);


ALTER TABLE ref_principal_activity OWNER TO postgres;

--
-- Name: user_authorities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE user_authorities (
    users_id bigint NOT NULL,
    auths character varying(255)
);


ALTER TABLE user_authorities OWNER TO postgres;

--
-- Name: user_profile; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE user_profile (
    id bigint NOT NULL,
    deleted character(1) NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    middle_name character varying(255),
    title character varying(255),
    user_id bigint
);


ALTER TABLE user_profile OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    id bigint NOT NULL,
    deleted character(1) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    role character varying(255),
    username character varying(255) NOT NULL
);


ALTER TABLE users OWNER TO postgres;

--
-- Name: chart_of_account chart_of_account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY chart_of_account
    ADD CONSTRAINT chart_of_account_pkey PRIMARY KEY (id);


--
-- Name: company company_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY company
    ADD CONSTRAINT company_pkey PRIMARY KEY (id);


--
-- Name: corporate_information corporate_information_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY corporate_information
    ADD CONSTRAINT corporate_information_pkey PRIMARY KEY (id);


--
-- Name: enumeration_answers enumeration_answers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY enumeration_answers
    ADD CONSTRAINT enumeration_answers_pkey PRIMARY KEY (question_answer_pair_id, idx);


--
-- Name: fs_level_1 fs_level_1_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fs_level_1
    ADD CONSTRAINT fs_level_1_pkey PRIMARY KEY (id);


--
-- Name: fs_level_2 fs_level_2_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fs_level_2
    ADD CONSTRAINT fs_level_2_pkey PRIMARY KEY (id);


--
-- Name: fs_level_3 fs_level_3_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fs_level_3
    ADD CONSTRAINT fs_level_3_pkey PRIMARY KEY (id);


--
-- Name: fs_level_4 fs_level_4_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fs_level_4
    ADD CONSTRAINT fs_level_4_pkey PRIMARY KEY (id);


--
-- Name: fs_level_5 fs_level_5_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fs_level_5
    ADD CONSTRAINT fs_level_5_pkey PRIMARY KEY (id);


--
-- Name: fs_level_6 fs_level_6_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fs_level_6
    ADD CONSTRAINT fs_level_6_pkey PRIMARY KEY (id);


--
-- Name: gpfs_note gpfs_note_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gpfs_note
    ADD CONSTRAINT gpfs_note_pkey PRIMARY KEY (id);


--
-- Name: gpfs gpfs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gpfs
    ADD CONSTRAINT gpfs_pkey PRIMARY KEY (id);


--
-- Name: gpfs_schedule_cells gpfs_schedule_cells_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gpfs_schedule_cells
    ADD CONSTRAINT gpfs_schedule_cells_pkey PRIMARY KEY (gpfs_schedule_rows_id, col_idx);


--
-- Name: gpfs_schedule gpfs_schedule_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gpfs_schedule
    ADD CONSTRAINT gpfs_schedule_pkey PRIMARY KEY (id);


--
-- Name: gpfs_schedule_rows gpfs_schedule_rows_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gpfs_schedule_rows
    ADD CONSTRAINT gpfs_schedule_rows_pkey PRIMARY KEY (id);


--
-- Name: question_answer_pair question_answer_pair_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY question_answer_pair
    ADD CONSTRAINT question_answer_pair_pkey PRIMARY KEY (id);


--
-- Name: question question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY question
    ADD CONSTRAINT question_pkey PRIMARY KEY (id);


--
-- Name: reconciliation_table reconciliation_table_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reconciliation_table
    ADD CONSTRAINT reconciliation_table_pkey PRIMARY KEY (id);


--
-- Name: ref_principal_activity ref_principal_activity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ref_principal_activity
    ADD CONSTRAINT ref_principal_activity_pkey PRIMARY KEY (id);


--
-- Name: users uk_6dotkott2kjsp8vw4d0m25fb7; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);


--
-- Name: users uk_r43af9ap4edm43mmtq01oddj6; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT uk_r43af9ap4edm43mmtq01oddj6 UNIQUE (username);


--
-- Name: gpfs ukbk8fqrumwce6vb413mc0ae6ic; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gpfs
    ADD CONSTRAINT ukbk8fqrumwce6vb413mc0ae6ic UNIQUE (company_id, year);


--
-- Name: user_profile user_profile_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_profile
    ADD CONSTRAINT user_profile_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: gpfs fk2h0x7km67qyh28s25mabhygir; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gpfs
    ADD CONSTRAINT fk2h0x7km67qyh28s25mabhygir FOREIGN KEY (company_id) REFERENCES company(id);


--
-- Name: question_answer_pair fk3kqw6hqmlc5g7cp5ra8uyf037; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY question_answer_pair
    ADD CONSTRAINT fk3kqw6hqmlc5g7cp5ra8uyf037 FOREIGN KEY (question_id) REFERENCES question(id);


--
-- Name: gpfs_schedule_cells fk3ota499x6hav1s7o0v5m8eil1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gpfs_schedule_cells
    ADD CONSTRAINT fk3ota499x6hav1s7o0v5m8eil1 FOREIGN KEY (gpfs_schedule_rows_id) REFERENCES gpfs_schedule_rows(id);


--
-- Name: fs_level_1 fk4tl6lhyk447clklggj9sm7w16; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fs_level_1
    ADD CONSTRAINT fk4tl6lhyk447clklggj9sm7w16 FOREIGN KEY (coa_id) REFERENCES chart_of_account(id);


--
-- Name: gpfs fk55uiu4fjp1uiaf0g5kshj1k7l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gpfs
    ADD CONSTRAINT fk55uiu4fjp1uiaf0g5kshj1k7l FOREIGN KEY (reconciliation_id) REFERENCES reconciliation_table(id);


--
-- Name: fs_level_3 fk5cuhrv81qmu0d1hed5toc2wos; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fs_level_3
    ADD CONSTRAINT fk5cuhrv81qmu0d1hed5toc2wos FOREIGN KEY (parent_id) REFERENCES fs_level_2(id);


--
-- Name: enumeration_answers fk5o5ibbbma6ybltqlo2uof8e4s; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY enumeration_answers
    ADD CONSTRAINT fk5o5ibbbma6ybltqlo2uof8e4s FOREIGN KEY (question_answer_pair_id) REFERENCES question_answer_pair(id);


--
-- Name: user_authorities fk985stoasq601j8db7t3ou5pt2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_authorities
    ADD CONSTRAINT fk985stoasq601j8db7t3ou5pt2 FOREIGN KEY (users_id) REFERENCES users(id);


--
-- Name: fs_level_6 fk9te8vqx99hpbrfbgvs4x3diox; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fs_level_6
    ADD CONSTRAINT fk9te8vqx99hpbrfbgvs4x3diox FOREIGN KEY (parent_id) REFERENCES fs_level_5(id);


--
-- Name: gpfs_schedule_rows fkdl4ocjn8t3b33i1r3vuv1brrx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gpfs_schedule_rows
    ADD CONSTRAINT fkdl4ocjn8t3b33i1r3vuv1brrx FOREIGN KEY (schedule_id) REFERENCES gpfs_schedule(id);


--
-- Name: question_mc_answers fkekvo4rkcbdjoxgnp97gg6bftp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY question_mc_answers
    ADD CONSTRAINT fkekvo4rkcbdjoxgnp97gg6bftp FOREIGN KEY (question_id) REFERENCES question(id);


--
-- Name: fs_level_4 fkfafn4fjts82v5u6uttx2fcget; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fs_level_4
    ADD CONSTRAINT fkfafn4fjts82v5u6uttx2fcget FOREIGN KEY (parent_id) REFERENCES fs_level_3(id);


--
-- Name: gpfs_note fkfj29f4l4mpclwfet5xb9an5w5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gpfs_note
    ADD CONSTRAINT fkfj29f4l4mpclwfet5xb9an5w5 FOREIGN KEY (gpfs_id) REFERENCES gpfs(id);


--
-- Name: fs_level_2 fkfkru8a57nnjr81dvgoia04v27; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fs_level_2
    ADD CONSTRAINT fkfkru8a57nnjr81dvgoia04v27 FOREIGN KEY (parent_id) REFERENCES fs_level_1(id);


--
-- Name: fs_level_5 fkiecyspqaml7lqevfxrpl4lstf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fs_level_5
    ADD CONSTRAINT fkiecyspqaml7lqevfxrpl4lstf FOREIGN KEY (parent_id) REFERENCES fs_level_4(id);


--
-- Name: gpfs fkjf6hkj73k1585dgjbi3jeo288; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gpfs
    ADD CONSTRAINT fkjf6hkj73k1585dgjbi3jeo288 FOREIGN KEY (coa_id) REFERENCES chart_of_account(id);


--
-- Name: gpfs_schedule fkq71nt79bhcnn20lrco0gs8i6c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gpfs_schedule
    ADD CONSTRAINT fkq71nt79bhcnn20lrco0gs8i6c FOREIGN KEY (gpfs_id) REFERENCES gpfs(id);


--
-- Name: question_answer_pair fkqn9amqlqahj0ctvj3cj50km39; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY question_answer_pair
    ADD CONSTRAINT fkqn9amqlqahj0ctvj3cj50km39 FOREIGN KEY (note_id) REFERENCES gpfs_note(id);


--
-- Name: gpfs fkrac6cldks8guetom12ucttjiu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gpfs
    ADD CONSTRAINT fkrac6cldks8guetom12ucttjiu FOREIGN KEY (pa_id) REFERENCES ref_principal_activity(id);


--
-- Name: user_profile fkuganfwvnbll4kn2a3jeyxtyi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_profile
    ADD CONSTRAINT fkuganfwvnbll4kn2a3jeyxtyi FOREIGN KEY (user_id) REFERENCES users(id);


--
-- PostgreSQL database dump complete
--

