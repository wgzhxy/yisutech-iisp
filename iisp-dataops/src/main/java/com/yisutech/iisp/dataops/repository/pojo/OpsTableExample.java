package com.yisutech.iisp.dataops.repository.pojo;

import java.util.ArrayList;
import java.util.List;

public class OpsTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpsTableExample() {
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

        public Criteria andTbNameIsNull() {
            addCriterion("tb_name is null");
            return (Criteria) this;
        }

        public Criteria andTbNameIsNotNull() {
            addCriterion("tb_name is not null");
            return (Criteria) this;
        }

        public Criteria andTbNameEqualTo(String value) {
            addCriterion("tb_name =", value, "tbName");
            return (Criteria) this;
        }

        public Criteria andTbNameNotEqualTo(String value) {
            addCriterion("tb_name <>", value, "tbName");
            return (Criteria) this;
        }

        public Criteria andTbNameGreaterThan(String value) {
            addCriterion("tb_name >", value, "tbName");
            return (Criteria) this;
        }

        public Criteria andTbNameGreaterThanOrEqualTo(String value) {
            addCriterion("tb_name >=", value, "tbName");
            return (Criteria) this;
        }

        public Criteria andTbNameLessThan(String value) {
            addCriterion("tb_name <", value, "tbName");
            return (Criteria) this;
        }

        public Criteria andTbNameLessThanOrEqualTo(String value) {
            addCriterion("tb_name <=", value, "tbName");
            return (Criteria) this;
        }

        public Criteria andTbNameLike(String value) {
            addCriterion("tb_name like", value, "tbName");
            return (Criteria) this;
        }

        public Criteria andTbNameNotLike(String value) {
            addCriterion("tb_name not like", value, "tbName");
            return (Criteria) this;
        }

        public Criteria andTbNameIn(List<String> values) {
            addCriterion("tb_name in", values, "tbName");
            return (Criteria) this;
        }

        public Criteria andTbNameNotIn(List<String> values) {
            addCriterion("tb_name not in", values, "tbName");
            return (Criteria) this;
        }

        public Criteria andTbNameBetween(String value1, String value2) {
            addCriterion("tb_name between", value1, value2, "tbName");
            return (Criteria) this;
        }

        public Criteria andTbNameNotBetween(String value1, String value2) {
            addCriterion("tb_name not between", value1, value2, "tbName");
            return (Criteria) this;
        }

        public Criteria andTbDescIsNull() {
            addCriterion("tb_desc is null");
            return (Criteria) this;
        }

        public Criteria andTbDescIsNotNull() {
            addCriterion("tb_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTbDescEqualTo(String value) {
            addCriterion("tb_desc =", value, "tbDesc");
            return (Criteria) this;
        }

        public Criteria andTbDescNotEqualTo(String value) {
            addCriterion("tb_desc <>", value, "tbDesc");
            return (Criteria) this;
        }

        public Criteria andTbDescGreaterThan(String value) {
            addCriterion("tb_desc >", value, "tbDesc");
            return (Criteria) this;
        }

        public Criteria andTbDescGreaterThanOrEqualTo(String value) {
            addCriterion("tb_desc >=", value, "tbDesc");
            return (Criteria) this;
        }

        public Criteria andTbDescLessThan(String value) {
            addCriterion("tb_desc <", value, "tbDesc");
            return (Criteria) this;
        }

        public Criteria andTbDescLessThanOrEqualTo(String value) {
            addCriterion("tb_desc <=", value, "tbDesc");
            return (Criteria) this;
        }

        public Criteria andTbDescLike(String value) {
            addCriterion("tb_desc like", value, "tbDesc");
            return (Criteria) this;
        }

        public Criteria andTbDescNotLike(String value) {
            addCriterion("tb_desc not like", value, "tbDesc");
            return (Criteria) this;
        }

        public Criteria andTbDescIn(List<String> values) {
            addCriterion("tb_desc in", values, "tbDesc");
            return (Criteria) this;
        }

        public Criteria andTbDescNotIn(List<String> values) {
            addCriterion("tb_desc not in", values, "tbDesc");
            return (Criteria) this;
        }

        public Criteria andTbDescBetween(String value1, String value2) {
            addCriterion("tb_desc between", value1, value2, "tbDesc");
            return (Criteria) this;
        }

        public Criteria andTbDescNotBetween(String value1, String value2) {
            addCriterion("tb_desc not between", value1, value2, "tbDesc");
            return (Criteria) this;
        }

        public Criteria andTbFiledsNumIsNull() {
            addCriterion("tb_fileds_num is null");
            return (Criteria) this;
        }

        public Criteria andTbFiledsNumIsNotNull() {
            addCriterion("tb_fileds_num is not null");
            return (Criteria) this;
        }

        public Criteria andTbFiledsNumEqualTo(Integer value) {
            addCriterion("tb_fileds_num =", value, "tbFiledsNum");
            return (Criteria) this;
        }

        public Criteria andTbFiledsNumNotEqualTo(Integer value) {
            addCriterion("tb_fileds_num <>", value, "tbFiledsNum");
            return (Criteria) this;
        }

        public Criteria andTbFiledsNumGreaterThan(Integer value) {
            addCriterion("tb_fileds_num >", value, "tbFiledsNum");
            return (Criteria) this;
        }

        public Criteria andTbFiledsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("tb_fileds_num >=", value, "tbFiledsNum");
            return (Criteria) this;
        }

        public Criteria andTbFiledsNumLessThan(Integer value) {
            addCriterion("tb_fileds_num <", value, "tbFiledsNum");
            return (Criteria) this;
        }

        public Criteria andTbFiledsNumLessThanOrEqualTo(Integer value) {
            addCriterion("tb_fileds_num <=", value, "tbFiledsNum");
            return (Criteria) this;
        }

        public Criteria andTbFiledsNumIn(List<Integer> values) {
            addCriterion("tb_fileds_num in", values, "tbFiledsNum");
            return (Criteria) this;
        }

        public Criteria andTbFiledsNumNotIn(List<Integer> values) {
            addCriterion("tb_fileds_num not in", values, "tbFiledsNum");
            return (Criteria) this;
        }

        public Criteria andTbFiledsNumBetween(Integer value1, Integer value2) {
            addCriterion("tb_fileds_num between", value1, value2, "tbFiledsNum");
            return (Criteria) this;
        }

        public Criteria andTbFiledsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("tb_fileds_num not between", value1, value2, "tbFiledsNum");
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