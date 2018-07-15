package edu.hnust.stu.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthIsNull() {
            addCriterion("birth is null");
            return (Criteria) this;
        }

        public Criteria andBirthIsNotNull() {
            addCriterion("birth is not null");
            return (Criteria) this;
        }

        public Criteria andBirthEqualTo(Date value) {
            addCriterionForJDBCDate("birth =", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotEqualTo(Date value) {
            addCriterionForJDBCDate("birth <>", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthGreaterThan(Date value) {
            addCriterionForJDBCDate("birth >", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birth >=", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLessThan(Date value) {
            addCriterionForJDBCDate("birth <", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birth <=", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthIn(List<Date> values) {
            addCriterionForJDBCDate("birth in", values, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotIn(List<Date> values) {
            addCriterionForJDBCDate("birth not in", values, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birth between", value1, value2, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birth not between", value1, value2, "birth");
            return (Criteria) this;
        }

        public Criteria andJavaIsNull() {
            addCriterion("java is null");
            return (Criteria) this;
        }

        public Criteria andJavaIsNotNull() {
            addCriterion("java is not null");
            return (Criteria) this;
        }

        public Criteria andJavaEqualTo(Double value) {
            addCriterion("java =", value, "java");
            return (Criteria) this;
        }

        public Criteria andJavaNotEqualTo(Double value) {
            addCriterion("java <>", value, "java");
            return (Criteria) this;
        }

        public Criteria andJavaGreaterThan(Double value) {
            addCriterion("java >", value, "java");
            return (Criteria) this;
        }

        public Criteria andJavaGreaterThanOrEqualTo(Double value) {
            addCriterion("java >=", value, "java");
            return (Criteria) this;
        }

        public Criteria andJavaLessThan(Double value) {
            addCriterion("java <", value, "java");
            return (Criteria) this;
        }

        public Criteria andJavaLessThanOrEqualTo(Double value) {
            addCriterion("java <=", value, "java");
            return (Criteria) this;
        }

        public Criteria andJavaIn(List<Double> values) {
            addCriterion("java in", values, "java");
            return (Criteria) this;
        }

        public Criteria andJavaNotIn(List<Double> values) {
            addCriterion("java not in", values, "java");
            return (Criteria) this;
        }

        public Criteria andJavaBetween(Double value1, Double value2) {
            addCriterion("java between", value1, value2, "java");
            return (Criteria) this;
        }

        public Criteria andJavaNotBetween(Double value1, Double value2) {
            addCriterion("java not between", value1, value2, "java");
            return (Criteria) this;
        }

        public Criteria andMathIsNull() {
            addCriterion("math is null");
            return (Criteria) this;
        }

        public Criteria andMathIsNotNull() {
            addCriterion("math is not null");
            return (Criteria) this;
        }

        public Criteria andMathEqualTo(Double value) {
            addCriterion("math =", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathNotEqualTo(Double value) {
            addCriterion("math <>", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathGreaterThan(Double value) {
            addCriterion("math >", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathGreaterThanOrEqualTo(Double value) {
            addCriterion("math >=", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathLessThan(Double value) {
            addCriterion("math <", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathLessThanOrEqualTo(Double value) {
            addCriterion("math <=", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathIn(List<Double> values) {
            addCriterion("math in", values, "math");
            return (Criteria) this;
        }

        public Criteria andMathNotIn(List<Double> values) {
            addCriterion("math not in", values, "math");
            return (Criteria) this;
        }

        public Criteria andMathBetween(Double value1, Double value2) {
            addCriterion("math between", value1, value2, "math");
            return (Criteria) this;
        }

        public Criteria andMathNotBetween(Double value1, Double value2) {
            addCriterion("math not between", value1, value2, "math");
            return (Criteria) this;
        }

        public Criteria andEnglishIsNull() {
            addCriterion("English is null");
            return (Criteria) this;
        }

        public Criteria andEnglishIsNotNull() {
            addCriterion("English is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishEqualTo(Double value) {
            addCriterion("English =", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishNotEqualTo(Double value) {
            addCriterion("English <>", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishGreaterThan(Double value) {
            addCriterion("English >", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishGreaterThanOrEqualTo(Double value) {
            addCriterion("English >=", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishLessThan(Double value) {
            addCriterion("English <", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishLessThanOrEqualTo(Double value) {
            addCriterion("English <=", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishIn(List<Double> values) {
            addCriterion("English in", values, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishNotIn(List<Double> values) {
            addCriterion("English not in", values, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishBetween(Double value1, Double value2) {
            addCriterion("English between", value1, value2, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishNotBetween(Double value1, Double value2) {
            addCriterion("English not between", value1, value2, "english");
            return (Criteria) this;
        }

        public Criteria andPeIsNull() {
            addCriterion("PE is null");
            return (Criteria) this;
        }

        public Criteria andPeIsNotNull() {
            addCriterion("PE is not null");
            return (Criteria) this;
        }

        public Criteria andPeEqualTo(Double value) {
            addCriterion("PE =", value, "pe");
            return (Criteria) this;
        }

        public Criteria andPeNotEqualTo(Double value) {
            addCriterion("PE <>", value, "pe");
            return (Criteria) this;
        }

        public Criteria andPeGreaterThan(Double value) {
            addCriterion("PE >", value, "pe");
            return (Criteria) this;
        }

        public Criteria andPeGreaterThanOrEqualTo(Double value) {
            addCriterion("PE >=", value, "pe");
            return (Criteria) this;
        }

        public Criteria andPeLessThan(Double value) {
            addCriterion("PE <", value, "pe");
            return (Criteria) this;
        }

        public Criteria andPeLessThanOrEqualTo(Double value) {
            addCriterion("PE <=", value, "pe");
            return (Criteria) this;
        }

        public Criteria andPeIn(List<Double> values) {
            addCriterion("PE in", values, "pe");
            return (Criteria) this;
        }

        public Criteria andPeNotIn(List<Double> values) {
            addCriterion("PE not in", values, "pe");
            return (Criteria) this;
        }

        public Criteria andPeBetween(Double value1, Double value2) {
            addCriterion("PE between", value1, value2, "pe");
            return (Criteria) this;
        }

        public Criteria andPeNotBetween(Double value1, Double value2) {
            addCriterion("PE not between", value1, value2, "pe");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}