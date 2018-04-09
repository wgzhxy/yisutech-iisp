package com.yisutech.iisp.dataops.repository.pojo;

import java.util.ArrayList;
import java.util.List;

public class OpsLogicTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpsLogicTableExample() {
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

        public Criteria andLtbSourceIdIsNull() {
            addCriterion("ltb_source_id is null");
            return (Criteria) this;
        }

        public Criteria andLtbSourceIdIsNotNull() {
            addCriterion("ltb_source_id is not null");
            return (Criteria) this;
        }

        public Criteria andLtbSourceIdEqualTo(Integer value) {
            addCriterion("ltb_source_id =", value, "ltbSourceId");
            return (Criteria) this;
        }

        public Criteria andLtbSourceIdNotEqualTo(Integer value) {
            addCriterion("ltb_source_id <>", value, "ltbSourceId");
            return (Criteria) this;
        }

        public Criteria andLtbSourceIdGreaterThan(Integer value) {
            addCriterion("ltb_source_id >", value, "ltbSourceId");
            return (Criteria) this;
        }

        public Criteria andLtbSourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ltb_source_id >=", value, "ltbSourceId");
            return (Criteria) this;
        }

        public Criteria andLtbSourceIdLessThan(Integer value) {
            addCriterion("ltb_source_id <", value, "ltbSourceId");
            return (Criteria) this;
        }

        public Criteria andLtbSourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("ltb_source_id <=", value, "ltbSourceId");
            return (Criteria) this;
        }

        public Criteria andLtbSourceIdIn(List<Integer> values) {
            addCriterion("ltb_source_id in", values, "ltbSourceId");
            return (Criteria) this;
        }

        public Criteria andLtbSourceIdNotIn(List<Integer> values) {
            addCriterion("ltb_source_id not in", values, "ltbSourceId");
            return (Criteria) this;
        }

        public Criteria andLtbSourceIdBetween(Integer value1, Integer value2) {
            addCriterion("ltb_source_id between", value1, value2, "ltbSourceId");
            return (Criteria) this;
        }

        public Criteria andLtbSourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ltb_source_id not between", value1, value2, "ltbSourceId");
            return (Criteria) this;
        }

        public Criteria andLtbTablesIsNull() {
            addCriterion("ltb_tables is null");
            return (Criteria) this;
        }

        public Criteria andLtbTablesIsNotNull() {
            addCriterion("ltb_tables is not null");
            return (Criteria) this;
        }

        public Criteria andLtbTablesEqualTo(String value) {
            addCriterion("ltb_tables =", value, "ltbTables");
            return (Criteria) this;
        }

        public Criteria andLtbTablesNotEqualTo(String value) {
            addCriterion("ltb_tables <>", value, "ltbTables");
            return (Criteria) this;
        }

        public Criteria andLtbTablesGreaterThan(String value) {
            addCriterion("ltb_tables >", value, "ltbTables");
            return (Criteria) this;
        }

        public Criteria andLtbTablesGreaterThanOrEqualTo(String value) {
            addCriterion("ltb_tables >=", value, "ltbTables");
            return (Criteria) this;
        }

        public Criteria andLtbTablesLessThan(String value) {
            addCriterion("ltb_tables <", value, "ltbTables");
            return (Criteria) this;
        }

        public Criteria andLtbTablesLessThanOrEqualTo(String value) {
            addCriterion("ltb_tables <=", value, "ltbTables");
            return (Criteria) this;
        }

        public Criteria andLtbTablesLike(String value) {
            addCriterion("ltb_tables like", value, "ltbTables");
            return (Criteria) this;
        }

        public Criteria andLtbTablesNotLike(String value) {
            addCriterion("ltb_tables not like", value, "ltbTables");
            return (Criteria) this;
        }

        public Criteria andLtbTablesIn(List<String> values) {
            addCriterion("ltb_tables in", values, "ltbTables");
            return (Criteria) this;
        }

        public Criteria andLtbTablesNotIn(List<String> values) {
            addCriterion("ltb_tables not in", values, "ltbTables");
            return (Criteria) this;
        }

        public Criteria andLtbTablesBetween(String value1, String value2) {
            addCriterion("ltb_tables between", value1, value2, "ltbTables");
            return (Criteria) this;
        }

        public Criteria andLtbTablesNotBetween(String value1, String value2) {
            addCriterion("ltb_tables not between", value1, value2, "ltbTables");
            return (Criteria) this;
        }

        public Criteria andLtbSqlExpressIsNull() {
            addCriterion("ltb_sql_express is null");
            return (Criteria) this;
        }

        public Criteria andLtbSqlExpressIsNotNull() {
            addCriterion("ltb_sql_express is not null");
            return (Criteria) this;
        }

        public Criteria andLtbSqlExpressEqualTo(String value) {
            addCriterion("ltb_sql_express =", value, "ltbSqlExpress");
            return (Criteria) this;
        }

        public Criteria andLtbSqlExpressNotEqualTo(String value) {
            addCriterion("ltb_sql_express <>", value, "ltbSqlExpress");
            return (Criteria) this;
        }

        public Criteria andLtbSqlExpressGreaterThan(String value) {
            addCriterion("ltb_sql_express >", value, "ltbSqlExpress");
            return (Criteria) this;
        }

        public Criteria andLtbSqlExpressGreaterThanOrEqualTo(String value) {
            addCriterion("ltb_sql_express >=", value, "ltbSqlExpress");
            return (Criteria) this;
        }

        public Criteria andLtbSqlExpressLessThan(String value) {
            addCriterion("ltb_sql_express <", value, "ltbSqlExpress");
            return (Criteria) this;
        }

        public Criteria andLtbSqlExpressLessThanOrEqualTo(String value) {
            addCriterion("ltb_sql_express <=", value, "ltbSqlExpress");
            return (Criteria) this;
        }

        public Criteria andLtbSqlExpressLike(String value) {
            addCriterion("ltb_sql_express like", value, "ltbSqlExpress");
            return (Criteria) this;
        }

        public Criteria andLtbSqlExpressNotLike(String value) {
            addCriterion("ltb_sql_express not like", value, "ltbSqlExpress");
            return (Criteria) this;
        }

        public Criteria andLtbSqlExpressIn(List<String> values) {
            addCriterion("ltb_sql_express in", values, "ltbSqlExpress");
            return (Criteria) this;
        }

        public Criteria andLtbSqlExpressNotIn(List<String> values) {
            addCriterion("ltb_sql_express not in", values, "ltbSqlExpress");
            return (Criteria) this;
        }

        public Criteria andLtbSqlExpressBetween(String value1, String value2) {
            addCriterion("ltb_sql_express between", value1, value2, "ltbSqlExpress");
            return (Criteria) this;
        }

        public Criteria andLtbSqlExpressNotBetween(String value1, String value2) {
            addCriterion("ltb_sql_express not between", value1, value2, "ltbSqlExpress");
            return (Criteria) this;
        }

        public Criteria andLtbTypeIsNull() {
            addCriterion("ltb_type is null");
            return (Criteria) this;
        }

        public Criteria andLtbTypeIsNotNull() {
            addCriterion("ltb_type is not null");
            return (Criteria) this;
        }

        public Criteria andLtbTypeEqualTo(Integer value) {
            addCriterion("ltb_type =", value, "ltbType");
            return (Criteria) this;
        }

        public Criteria andLtbTypeNotEqualTo(Integer value) {
            addCriterion("ltb_type <>", value, "ltbType");
            return (Criteria) this;
        }

        public Criteria andLtbTypeGreaterThan(Integer value) {
            addCriterion("ltb_type >", value, "ltbType");
            return (Criteria) this;
        }

        public Criteria andLtbTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ltb_type >=", value, "ltbType");
            return (Criteria) this;
        }

        public Criteria andLtbTypeLessThan(Integer value) {
            addCriterion("ltb_type <", value, "ltbType");
            return (Criteria) this;
        }

        public Criteria andLtbTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ltb_type <=", value, "ltbType");
            return (Criteria) this;
        }

        public Criteria andLtbTypeIn(List<Integer> values) {
            addCriterion("ltb_type in", values, "ltbType");
            return (Criteria) this;
        }

        public Criteria andLtbTypeNotIn(List<Integer> values) {
            addCriterion("ltb_type not in", values, "ltbType");
            return (Criteria) this;
        }

        public Criteria andLtbTypeBetween(Integer value1, Integer value2) {
            addCriterion("ltb_type between", value1, value2, "ltbType");
            return (Criteria) this;
        }

        public Criteria andLtbTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ltb_type not between", value1, value2, "ltbType");
            return (Criteria) this;
        }

        public Criteria andLtbDescIsNull() {
            addCriterion("ltb_desc is null");
            return (Criteria) this;
        }

        public Criteria andLtbDescIsNotNull() {
            addCriterion("ltb_desc is not null");
            return (Criteria) this;
        }

        public Criteria andLtbDescEqualTo(String value) {
            addCriterion("ltb_desc =", value, "ltbDesc");
            return (Criteria) this;
        }

        public Criteria andLtbDescNotEqualTo(String value) {
            addCriterion("ltb_desc <>", value, "ltbDesc");
            return (Criteria) this;
        }

        public Criteria andLtbDescGreaterThan(String value) {
            addCriterion("ltb_desc >", value, "ltbDesc");
            return (Criteria) this;
        }

        public Criteria andLtbDescGreaterThanOrEqualTo(String value) {
            addCriterion("ltb_desc >=", value, "ltbDesc");
            return (Criteria) this;
        }

        public Criteria andLtbDescLessThan(String value) {
            addCriterion("ltb_desc <", value, "ltbDesc");
            return (Criteria) this;
        }

        public Criteria andLtbDescLessThanOrEqualTo(String value) {
            addCriterion("ltb_desc <=", value, "ltbDesc");
            return (Criteria) this;
        }

        public Criteria andLtbDescLike(String value) {
            addCriterion("ltb_desc like", value, "ltbDesc");
            return (Criteria) this;
        }

        public Criteria andLtbDescNotLike(String value) {
            addCriterion("ltb_desc not like", value, "ltbDesc");
            return (Criteria) this;
        }

        public Criteria andLtbDescIn(List<String> values) {
            addCriterion("ltb_desc in", values, "ltbDesc");
            return (Criteria) this;
        }

        public Criteria andLtbDescNotIn(List<String> values) {
            addCriterion("ltb_desc not in", values, "ltbDesc");
            return (Criteria) this;
        }

        public Criteria andLtbDescBetween(String value1, String value2) {
            addCriterion("ltb_desc between", value1, value2, "ltbDesc");
            return (Criteria) this;
        }

        public Criteria andLtbDescNotBetween(String value1, String value2) {
            addCriterion("ltb_desc not between", value1, value2, "ltbDesc");
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