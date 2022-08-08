package com.ub.card.dao;

import com.ub.card.model.Person;
import com.ub.card.model.PersonImage;
import com.ub.card.model.Term;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by matshedisoo on 5/19/2016.
 */
@Repository
public class PersonDao {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("jdbcTest")
    protected JdbcTemplate jdbcTest;

    public List<Person> getPerson(String id) {

        String sql = "SELECT ub_cagunum as CAGUNUM " +
                "from Ubint.Ub_Imp_Idcrd_Tb where ub_cagunum = ?";

        List<Person> persons = jdbcTest.query(
                sql,new Object[]{id},  new BeanPropertyRowMapper(Person.class));

        return persons;
    }

    public List<Person> getRecordsWithPhoto(){

        /*String sql = "Select cagcard, cagnumtype, cagseq, cagunum, cagphotoindb, cagdate, cagline1, cagline2, cagline3,  cagline4," +
                "cagline5,cagedate,cagline8, cagline9, cagline10, cagline11, cagline12, cagline18, cagline19, cagline16 " +
                "From CARD.CAGCRD where TO_CHAR(cagdate,'YYYY') = '2016'";*/

        /*String sql = "Select ub_cagcard as cagcard, ub_cagnumtype as cagnumtype, ub_cagseq as cagseq, ub_cagunum as cagunum, ub_cagdate as cagdate, ub_cagline1 as cagline1, ub_cagline2 as cagline2, ub_cagline3 as cagline3,  ub_cagline4 as cagline4," +
                "ub_cagline5 as cagline5,ub_cagedate as cagedate,ub_cagline8 as cagline8, ub_cagline9 as cagline9, ub_cagline10 as cagline10, ub_cagline11 as cagline11, ub_cagline12 as cagline12, ub_cagline18 as cagline18, ub_cagline19 as cagline19, ub_cagline16 as cagline16 " +
                "From Ubint.Ub_Imp_Idcrd_Tb where to_date(ub_cagdate,'DD=MON-YYYY') >= to_date(sysdate,'DD=MON-YYYY')";*/

        String sql = "Select ub_cagcard as cagcard, ub_cagnumtype as cagnumtype, ub_cagseq as cagseq, ub_cagunum as cagunum, ub_cagdate as cagdate, ub_cagline1 as cagline1, ub_cagline2 as cagline2, ub_cagline3 as cagline3,  ub_cagline4 as cagline4," +
                "ub_cagline5 as cagline5,ub_cagedate as cagedate,ub_cagline8 as cagline8, ub_cagline9 as cagline9, ub_cagline10 as cagline10, ub_cagline11 as cagline11, ub_cagline12 as cagline12, ub_cagline18 as cagline18, ub_cagline19 as cagline19, ub_cagline16 as cagline16 " +
                "From Ubint.Ub_Imp_Idcrd_Tb where ub_cagdate between to_date('01-May-2021', 'dd-mon-yyyy') and sysdate";

        List<Person> persons  = jdbcTest.query(sql, new BeanPropertyRowMapper(Person.class));

        System.out.println(persons);

        return persons;
    }

    public List<Person> getPersonToIts(String id) {

        String sql = "Select distinct ub_cagunum as Cagunum, " +
                "ub_cagcard as Cagcard, " +
                "ub_cagseq as Cagseq, " +
                "ub_cagnumtype as Cagnumtype, " +
                "ub_cagdate as Cagdate, " +
                "ub_cagline1 as Cagline1, " +
                "ub_cagline2 as Cagline2 /*Identity_No*/, " +
                "ub_cagline3 as Cagline3/*Program_of_Study*/, " +
                "ub_cagline4 as Cagline4/*Faculty*/," +
                "ub_cagline5 as Cagline5 /*Fulltime/Parttime*/, " +
                "ub_cagline7 as Cagline7/*Academic_Career*/, " +
                "ub_cagline8 as Cagline8, " +
                "ub_cagline9 as cagline9, " +
                "ub_cagline10 as cagline10, " +
                "ub_cagline11 as cagline11, " +
                "ub_cagline12 as cagline12, " +
                "ub_cagedate as Cagedate, " +
                "ub_staff_edate as Cagpedate, " +
                "ub_cagline16 as cagline16, " +
                "ub_cagline18 AS CAGLINE18, " +
                "ub_cagline19 as cagline19 " +
                "from Ubint.Ub_Imp_Idcrd_Tb where ub_cagunum = ?";

        List<Person> persons = jdbcTest.query(
                sql,new Object[]{id},  new BeanPropertyRowMapper(Person.class));

        return persons;
    }

    @Transactional(readOnly=true)
    public Iterable<Person> findIntByTerm(int terma,int termb) {

        String sql = "Select distinct a.emplid as Cagunum, " +
                "a.emplid||'01' as cagcard, " +
                "substr(a.emplid||'01', length(a.emplid||'01')-1, 2) as cagseq, " +
                "'S' as Cagnumtype, " +
                "sysdate as Cagdate, " +
                "a.name_prefix||' '||substr(a.first_name, 1, 1)||'.'|| substr(a.middle_name, 1, 1)||decode(Length(substr(a.middle_name, 1, 2)), 1, ' ', 2, '. ')||a.last_name as Cagline1, " +
                "j.country||'-'||j.national_id as Cagline2 /*Identity_No*/, " +
                "e.descr as Cagline3/*Program_of_Study*/, " +
                "b.descr as Cagline4/*Faculty*/, " +
                "decode(h.acad_load_appr, 'P', 'Part-Time', 'F', 'Full-Time') as Cagline5 /*Fulltime/Parttime*/, " +
                "i.descr as Cagline7/*Academic_Career*/, " +
                "a.name_prefix as Cagline8, " +
                "a.first_name as cagline9, " +
                "a.middle_name as cagline10, " +
                "a.last_name as cagline11, " +
                "a.sex as cagline12, " +
                "'' as cagline16, " +
                "to_char(to_number(B.ACAD_GROUP)) as cagline18, " +
                "'' as cagline19, " +
                "'31/DEC/'||To_Char(to_number(h.acad_year)  ) as Cagedate " +
                "from CS9PROD.PS_PERSONAL_DATA a, " +
                "cs9prod.Ps_Acad_Group_tbl b, " +
                "cs9prod.ps_degree_tbl d, " +
                "cs9prod.ps_acad_prog_tbl e, " +
                "cs9prod.ps_acad_plan_tbl f, " +
                "cs9prod.Ps_Stdnt_Car_Term h, " +
                "cs9prod.ps_acad_car_tbl i, " +
                "cs9prod.ps_pers_nid j " +
                "where a.emplid = h.emplid " +
                "and a.emplid = j.emplid " +
                "and j.primary_nid = 'Y' " +
                "and d.degree = f.degree " +
                "and b.acad_group = e.acad_group " +
                "and e.acad_prog = h.acad_prog_primary " +
                "and e.descr  = 'Non-Degree Purpose/Short Cours' " +
                "and h.acad_career = i.acad_career " +
                "and h.strm in (?,?) " +
                "and a.emplid not in (Select ub_cagunum from Ubint.Ub_Imp_Idcrd_Tb)" +
                //"and years_of_educatn = 1 "+
                "order by a.emplid";

        Iterable<Person> persons  = jdbcTest.query(sql, new Object[] { terma,termb },
                new BeanPropertyRowMapper(Person.class));

        return persons;
    }

    @Transactional(readOnly=true)
    public Iterable<Person> findUpdateByTerm(int terma,int termb) {

        String sql = "Select distinct a.emplid as Cagunum, " +
                "a.emplid||'01' as cagcard, " +
                "substr(a.emplid||'01', length(a.emplid||'01')-1, 2) as cagseq, " +
                "'S' as Cagnumtype, " +
                "sysdate as Cagdate, " +
                "a.name_prefix||' '||substr(a.first_name, 1, 1)||'.'|| substr(a.middle_name, 1, 1)||decode(Length(substr(a.middle_name, 1, 2)), 1, ' ', 2, '. ')||a.last_name as Cagline1, " +
                "j.country||'-'||j.national_id as Cagline2 /*Identity_No*/, " +
                "e.descr as Cagline3/*Program_of_Study*/, " +
                "b.descr as Cagline4/*Faculty*/, " +
                "decode(h.acad_load_appr, 'P', 'Part-Time', 'F', 'Full-Time') as Cagline5 /*Fulltime/Parttime*/, " +
                "i.descr as Cagline7/*Academic_Career*/, " +
                "a.name_prefix as Cagline8, " +
                "a.first_name as cagline9, " +
                "a.middle_name as cagline10, " +
                "a.last_name as cagline11, " +
                "a.sex as cagline12, " +
                "'' as cagline16, " +
                "to_char(to_number(B.ACAD_GROUP)) as cagline18, " +
                "'' as cagline19, " +
                "'31/MAY/'||To_Char(to_number(h.acad_year)+ (to_number(d.years_of_educatn)- to_number(decode(h.acad_level_bot, '01', '1', '02', '2', '03', '3', '04', '4', '05', '5', '06', '6', '07', '7', '08', '8', '09', '9', 'MAS', '2', 'PHD', '3'))+ 1)  ) as Cagedate " +
                "from CS9PROD.PS_PERSONAL_DATA a, " +
                "cs9prod.Ps_Acad_Group_tbl b, " +
                "cs9prod.ps_degree_tbl d, " +
                "cs9prod.ps_acad_prog_tbl e, " +
                "cs9prod.ps_acad_plan_tbl f, " +
                "cs9prod.Ps_Stdnt_Car_Term h, " +
                "cs9prod.ps_acad_car_tbl i, " +
                "cs9prod.PS_STDNT_ENRL C, " +
                "cs9prod.ps_pers_nid j " +
                "where a.emplid = h.emplid " +
                "and a.emplid = j.emplid " +
                "and j.primary_nid = 'Y' " +
                "and d.degree = f.degree " +
                "and b.acad_group = e.acad_group " +
                "and e.acad_prog = h.acad_prog_primary " +
                "and e.acad_prog = f.acad_prog " +
                "and h.acad_career = i.acad_career " +
                "and c.STDNT_ENRL_STATUS = 'E' " +
                "and  C.EMPLID = a.EMPLID " +
                "AND C.STRM = h.strm " +
                "and h.strm in (?,?) " +
                //"and years_of_educatn = 1 "+
                "order by a.emplid";

        Iterable<Person> persons  = jdbcTest.query(sql, new Object[] { terma,termb },
                new BeanPropertyRowMapper(Person.class));

        return persons;
    }

    @Transactional(readOnly=true)
    public Iterable<Person> findUpdateByTermById(int terma,int termb, String id) {

        String sql = "Select distinct a.emplid as Cagunum, " +
                "a.emplid||'01' as cagcard, " +
                "substr(a.emplid||'01', length(a.emplid||'01')-1, 2) as cagseq, " +
                "'S' as Cagnumtype, " +
                "sysdate as Cagdate, " +
                "a.name_prefix||' '||substr(a.first_name, 1, 1)||'.'|| substr(a.middle_name, 1, 1)||decode(Length(substr(a.middle_name, 1, 2)), 1, ' ', 2, '. ')||a.last_name as Cagline1, " +
                "j.country||'-'||j.national_id as Cagline2 /*Identity_No*/, " +
                "e.descr as Cagline3/*Program_of_Study*/, " +
                "b.descr as Cagline4/*Faculty*/, " +
                "decode(h.acad_load_appr, 'P', 'Part-Time', 'F', 'Full-Time') as Cagline5 /*Fulltime/Parttime*/, " +
                "i.descr as Cagline7/*Academic_Career*/, " +
                "a.name_prefix as Cagline8, " +
                "a.first_name as cagline9, " +
                "a.middle_name as cagline10, " +
                "a.last_name as cagline11, " +
                "a.sex as cagline12, " +
                "'' as cagline16, " +
                "to_char(to_number(B.ACAD_GROUP)) as cagline18, " +
                "'' as cagline19, " +
                "'31/MAY/'||To_Char(to_number(h.acad_year)+ (to_number(d.years_of_educatn)- to_number(decode(h.acad_level_bot, '01', '1', '02', '2', '03', '3', '04', '4', '05', '5', '06', '6', '07', '7', '08', '8', '09', '9', 'MAS', '2', 'PHD', '3'))+ 1)  ) as Cagedate " +
                "from CS9PROD.PS_PERSONAL_DATA a, " +
                "cs9prod.Ps_Acad_Group_tbl b, " +
                "cs9prod.ps_degree_tbl d, " +
                "cs9prod.ps_acad_prog_tbl e, " +
                "cs9prod.ps_acad_plan_tbl f, " +
                "cs9prod.Ps_Stdnt_Car_Term h, " +
                "cs9prod.ps_acad_car_tbl i, " +
                "cs9prod.PS_STDNT_ENRL C, " +
                "cs9prod.ps_pers_nid j " +
                "where a.emplid = h.emplid " +
                "and a.emplid = j.emplid " +
                "and j.primary_nid = 'Y' " +
                "and d.degree = f.degree " +
                "and b.acad_group = e.acad_group " +
                "and e.acad_prog = h.acad_prog_primary " +
                "and e.acad_prog = f.acad_prog " +
                "and h.acad_career = i.acad_career " +
                "and c.STDNT_ENRL_STATUS = 'E' " +
                "and  C.EMPLID = a.EMPLID " +
                "AND C.STRM = h.strm " +
                "and h.strm in (?,?) " +
                "and  C.EMPLID = ? " +
                //"and years_of_educatn = 1 "+
                "order by a.emplid";

        Iterable<Person> persons  = jdbcTest.query(sql, new Object[] { terma,termb,id },
                new BeanPropertyRowMapper(Person.class));

        return persons;
    }

    @Transactional(readOnly=true)
    public Iterable<Person> findAllByTerm(int terma,int termb) {

        /*String sql = "SELECT DISTINCT H.EMPLID as CAGUNUM, H.EMPLID||'01' as CAGCARD," +
                "substr(H.EMPLID||'01', length(H.EMPLID||'01')-1, 2) as CAGSEQ,'S' as CAGNUMTYPE,sysdate as CAGDATE," +
                "H.name_prefix||' '||substr(H.FIRST_NAME, 1, 1)||'.'|| substr(H.MIDDLE_NAME, 1, 1)||decode(Length(substr(H.MIDDLE_NAME, 1, 2)), 1, ' ', 2, '. ')||H.LAST_NAME as CAGLINE1," +
                "PSS.COUNTRY||'-'||PSS.NATIONAL_ID as CAGLINE2 Identity_No," +
                "E.DESCR as CAGLINE3," +
                "F.DESCR as CAGLINE4," +
                "decode(TM.ACAD_LOAD_APPR, 'P', 'Part-Time', 'F', 'Full-Time') as CAGLINE5," +
                "H.NAME_PREFIX as CAGLINE8," +
                "H.FIRST_NAME as CAGLINE9," +
                "H.MIDDLE_NAME as CAGLINE10," +
                "H.LAST_NAME as CAGLINE11," +
                "H.SEX as CAGLINE12," +
                "'' as CAGLINE16," +
                "to_char(to_number(E.ACAD_GROUP)) as CAGLINE18," +
                "'' as CAGLINE19," +
                "'31/MAY/'||To_Char(to_number(TM.ACAD_YEAR)+ (to_number(G.years_of_educatn)- to_number(decode(TM.acad_level_bot, '01', '1', '02', '2', '03', '3', '04', '4', '05', '5', '06', '6', '07', '7', '08', '8', '09', '9', 'MAS', '2', 'PHD', '3'))+ 1)  ) as CAGEDATE " +
                " FROM cs9prod.PS_PERSONAL_DATA H, cs9prod.PS_STDNT_CAR_TERM TM, cs9prod.PS_ACAD_PROG_TBL E, cs9prod.PS_STDNT_ENRL C," +
                "cs9prod.PS_ACAD_GROUP_TBL F, cs9prod.PS_DEGREE_TBL G, cs9prod.ps_acad_plan_tbl J," +
                "(SELECT  PHONE, EMPLID from cs9prod.PS_PERSONAL_PHONE where PREF_PHONE_FLAG = 'Y' ) PSP," +
                "(SELECT v.EMPLID,COUNT(CLASS_NBR) ct, MAX(ENRL_ADD_DT) Dt FROM cs9prod.PS_STDNT_ENRL v WHERE  v.STRM = ? " +
                "     AND v.STDNT_ENRL_STATUS = 'E'" +
                "     group by v.emplid) ss," +
                "(select a.emplid,  a.NATIONAL_ID, A.NATIONAL_ID_TYPE,A.COUNTRY FROM cs9prod.PS_PERS_NID a where a.PRIMARY_NID = 'Y') PSS " +
                "WHERE H.EMPLID = TM.EMPLID " +
                "AND TM.STRM = ? " +
                "and tm.ACAD_PROG_PRIMARY = e.ACAD_PROG " +
                "and TM.ACAD_CAREER = C.ACAD_CAREER " +
                "and c.STDNT_ENRL_STATUS = 'E' " +
                "AND C.EMPLID = H.EMPLID " +
                "AND C.STRM = ? " +
                "AND E.ACAD_GROUP = F.ACAD_GROUP " +
                "AND H.EMPLID = PSS.EMPLID(+) " +
                "AND h.EMPLID = ss.EMPLID " +
                "AND H.EMPLID = PSP.EMPLID(+) " +
                "and G.degree = J.degree " +
                "and E.acad_prog = J.acad_prog " +
                "and H.emplid not in (Select ub_cagunum from Ubint.Ub_Imp_Idcrd_Tb) " +
                "order by 1,10,2";*/

        String sql = "Select distinct a.emplid as Cagunum, " +
                "a.emplid||'01' as cagcard, " +
                "substr(a.emplid||'01', length(a.emplid||'01')-1, 2) as cagseq, " +
                "'S' as Cagnumtype, " +
                "sysdate as Cagdate, " +
                "a.name_prefix||' '||substr(a.first_name, 1, 1)||'.'|| substr(a.middle_name, 1, 1)||decode(Length(substr(a.middle_name, 1, 2)), 1, ' ', 2, '. ')||a.last_name as Cagline1, " +
                "j.country||'-'||j.national_id as Cagline2 /*Identity_No*/, " +
                "e.descr as Cagline3/*Program_of_Study*/, " +
                "b.descr as Cagline4/*Faculty*/, " +
                "decode(h.acad_load_appr, 'P', 'Part-Time', 'F', 'Full-Time') as Cagline5 /*Fulltime/Parttime*/, " +
                "i.descr as Cagline7/*Academic_Career*/, " +
                "a.name_prefix as Cagline8, " +
                "a.first_name as cagline9, " +
                "a.middle_name as cagline10, " +
                "a.last_name as cagline11, " +
                "a.sex as cagline12, " +
                "'' as cagline16, " +
                "to_char(to_number(B.ACAD_GROUP)) as cagline18, " +
                "'' as cagline19, " +
                "'31/MAY/'||To_Char(to_number(h.acad_year)+ (to_number(d.years_of_educatn)- to_number(decode(h.acad_level_bot, '01', '1', '02', '2', '03', '3', '04', '4', '05', '5', '06', '6', '07', '7', '08', '8', '09', '9', 'MAS', '2', 'PHD', '3'))+ 1)  ) as Cagedate " +
                "from CS9PROD.PS_PERSONAL_DATA a, " +
                "cs9prod.Ps_Acad_Group_tbl b, " +
                "cs9prod.ps_degree_tbl d, " +
                "cs9prod.ps_acad_prog_tbl e, " +
                "cs9prod.ps_acad_plan_tbl f, " +
                "cs9prod.Ps_Stdnt_Car_Term h, " +
                "cs9prod.ps_acad_car_tbl i, " +
                "cs9prod.ps_pers_nid j " +
                "where a.emplid = h.emplid " +
                "and a.emplid = j.emplid " +
                "and j.primary_nid = 'Y' " +
                "and d.degree = f.degree " +
                "and b.acad_group = e.acad_group " +
                "and e.acad_prog = h.acad_prog_primary " +
                "and e.acad_prog = f.acad_prog " +
                "and h.acad_career = i.acad_career " +
                "and h.strm in (?,?) " +
                "and a.emplid not in (Select ub_cagunum from Ubint.Ub_Imp_Idcrd_Tb)" +
                //"and years_of_educatn = 1 "+
                "order by a.emplid";

        Iterable<Person> persons  = jdbcTest.query(sql, new Object[] { terma,termb },
                new BeanPropertyRowMapper(Person.class));

        return persons;
    }



    @Transactional(readOnly=true)
    public Iterable<Person> findAllByTermToIts(int terma,int termb) {

        String sql = "Select distinct ub_cagunum as Cagunum, " +
                "ub_cagcard as Cagcard, " +
                "ub_cagseq as Cagseq, " +
                "ub_cagnumtype as Cagnumtype, " +
                "ub_cagdate as Cagdate, " +
                "ub_cagline1 as Cagline1, " +
                "ub_cagline2 as Cagline2 /*Identity_No*/, " +
                "ub_cagline3 as Cagline3/*Program_of_Study*/, " +
                "ub_cagline4 as Cagline4/*Faculty*/," +
                "ub_cagline5 as Cagline5 /*Fulltime/Parttime*/, " +
                "ub_cagline7 as Cagline7/*Academic_Career*/, " +
                "ub_cagline8 as Cagline8, " +
                "ub_cagline9 as cagline9, " +
                "ub_cagline10 as cagline10, " +
                "ub_cagline11 as cagline11, " +
                "ub_cagline12 as cagline12, " +
                "ub_cagedate as Cagedate, " +
                "ub_staff_edate as Cagpedate, " +
                "ub_cagline16 as cagline16, " +
                "ub_cagline18 AS CAGLINE18, " +
                "ub_cagline19 as cagline19 " +
                "from ubint.ub_imp_idcrd_tb " +
                "where ub_cagline16 is null " +
                "and ub_cagline19 is not null " +
                "and ub_cagnumtype = 'S' " +
                "and ub_cagunum in (select distinct emplid from cs9prod.ps_stdnt_car_term where strm in (?,?)) " +
                "order by ub_cagunum";

        Iterable<Person> persons  = jdbcTest.query(sql, new Object[] { terma, termb },
                new BeanPropertyRowMapper(Person.class));

        return persons;
    }

    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public void updatePerson(Person person){

        String sql = "Update ubint.ub_imp_idcrd_tb set ub_cagline16 = 'TRANSFER' where ub_cagunum = ?";
        jdbcTest.update(sql, new Object[] { person.getCAGUNUM()});
    }


    public Integer getNextSeq(){
        String seq = "select ubint.mst_sq.nextval as CAGSEQ from dual";
        int nextSeq = jdbcTest.queryForObject(seq, new Object[]{},Integer.class);

        return nextSeq;
    }

    public Integer getNextSeqTest(){
        String seq = "select ubint.mst_sq_test.nextval as CAGSEQ from dual";
        int nextSeq = jdbcTest.queryForObject(seq, new Object[]{},Integer.class);

        return nextSeq;
    }

    public void insertPerson(Person person){

        String seq = "select ubint.mst_sq.nextval as CAGSEQ from dual";
        int nextSeq = jdbcTest.queryForObject(seq, new Object[]{},Integer.class);

        String sql = "INSERT INTO ubint.ub_imp_idcrd_tb(ub_cagcard, ub_cagnumtype, ub_cagseq, ub_cagunum, ub_cagohotoindb, ub_cagdate, ub_cagline1, ub_cagline2, ub_cagline3,  ub_cagline4,"+
        "ub_cagline5,ub_cagedate,ub_cagline8, ub_cagline9, ub_cagline10, ub_cagline11, ub_cagline12, ub_cagline18, ub_cagline19)"+
        "Values (:cagcard,:cagnumtype, :cagseq, :cagunum, :cagphotoindb, :cagdate, :cagline1,:cagline2,:cagline3,:cagline4,:cagline5,:cagedate,:cagline8,:cagline9,"+
        ":cagline10,:cagline11,:cagline12, :cagline18, :cagline19)";

        String asasSql = "INSERT INTO matshedisodba.UB_EXP_IDCRD_TB(emplid, ub_cagline19, ub_cagseq)"+
                "Values (:emplid, :cagline19,:ub_cagseq)";

        /*Date expirtDate = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            expirtDate = simpleDateFormat.parse(person.getCAGEDATE());
        }catch(ParseException parseException){
            parseException.printStackTrace();
        }
        java.sql.Date expiry = new java.sql.Date(expirtDate.getTime());*/

        System.out.println(person.toString());

        jdbcTest.update(sql, new Object[] { person.getCAGCARD(),person.getCAGNUMTYPE(), person.getCAGSEQ(),person.getCAGUNUM(),"N",getCurrentDate(),
                person.getCAGLINE1(),person.getCAGLINE2(),person.getCAGLINE3(),person.getCAGLINE4(),person.getCAGLINE5(),person.getCAGEDATE(),person.getCAGLINE8(),person.getCAGLINE9(),
                person.getCAGLINE10(),person.getCAGLINE11(),person.getCAGLINE12(),person.getCAGLINE18(),nextSeq
        });

       // jdbcTest.update(asasSql, new Object[] { person.getCAGUNUM(),nextSeq, person.getCAGSEQ() });
    }

    private static final RowMapper<Person> itemMapper = new RowMapper<Person>() {
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person item = new Person();
            item.setCAGUNUM(rs.getString("CAGUNUM"));
            return item;
        }
    };

    public Term getTerms(){

        String sql = "select max(strm) STRMA, min(strm) STRMB from cs9prod.ps_term_tbl where sysdate between term_begin_dt and term_end_dt";
        Term terms = (Term)jdbcTest.queryForObject(sql, new Object[] {  }, termMapper);

        return terms;
    }

    private static final RowMapper<Term> termMapper = new RowMapper<Term>() {
        public Term mapRow(ResultSet rs, int rowNum) throws SQLException {
            Term item = new Term(rs.getString("STRMA"),rs.getString("STRMB"));
            return item;
        }
    };

    private static final RowMapper<PersonImage> personImageRowMapper = new RowMapper<PersonImage>() {
        public PersonImage mapRow(ResultSet rs, int rowNum) throws SQLException {
            PersonImage personImage = new PersonImage(rs.getBytes("UB_CAGPHOTOIMG"));
            return personImage;
        }
    };



    public PersonImage getImage(String id) {

        String sql = "Select UB_CAGPHOTOIMG " +
                "From Ubint.Ub_Imp_Idcrd_Tb where ub_cagunum = ?";

        return  jdbcTest.queryForObject(sql, new Object[]{id},  personImageRowMapper);

    }
}
