package com.yisutech.iisp.dataops.repository.pojo;

import java.util.ArrayList;
import java.util.List;

public class OpsLogicTableColumnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpsLogicTableColumnExample() {
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

        public Criteria andLfdNameIsNull() {
            addCriterion("lfd_name is null");
            return (Criteria) this;
        }

        public Criteria andLfdNameIsNotNull() {
            addCriterion("lfd_name is not null");
            return (Criteria) this;
        }

        public Criteria andLfdNameEqualTo(String value) {
            addCriterion("lfd_name =", value, "lfdName");
            return (Criteria) this;
        }

        public Criteria andLfdNameNotEqualTo(String value) {
            addCriterion("lfd_name <>", value, "lfdName");
            return (Criteria) this;
        }

        public Criteria andLfdNameGreaterThan(String value) {
            addCriterion("lfd_name >", value, "lfdName");
            return (Criteria) this;
        }

        public Criteria andLfdNameGreaterThanOrEqualTo(String value) {
            addCriterion("lfd_name >=", value, "lfdName");
            return (Criteria) this;
        }

        public Criteria andLfdNameLessThan(String value) {
            addCriterion("lfd_name <", value, "lfdName");
            return (Criteria) this;
        }

        public Criteria andLfdNameLessThanOrEqualTo(String value) {
            addCriterion("lfd_name <=", value, "lfdName");
            return (Criteria) this;
        }

        public Criteria andLfdNameLike(String value) {
            addCriterion("lfd_name like", value, "lfdName");
            return (Criteria) this;
        }

        public Criteria andLfdNameNotLike(String value) {
            addCriterion("lfd_name not like", value, "lfdName");
            return (Criteria) this;
        }

        public Criteria andLfdNameIn(List<String> values) {
            addCriterion("lfd_name in", values, "lfdName");
            return (Criteria) this;
        }

        public Criteria andLfdNameNotIn(List<String> values) {
            addCriterion("lfd_name not in", values, "lfdName");
            return (Criteria) this;
        }

        public Criteria andLfdNameBetween(String value1, String value2) {
            addCriterion("lfd_name between", value1, value2, "lfdName");
            return (Criteria) this;
        }

        public Criteria andLfdNameNotBetween(String value1, String value2) {
            addCriterion("lfd_name not between", value1, value2, "lfdName");
            return (Criteria) this;
        }

        public Criteria andLfdTypeIsNull() {
            addCriterion("lfd_type is null");
            return (Criteria) this;
        }

        public Criteria andLfdTypeIsNotNull() {
            addCriterion("lfd_type is not null");
            return (Criteria) this;
        }

        public Criteria andLfdTypeEqualTo(String value) {
            addCriterion("lfd_type =", value, "lfdType");
            return (Criteria) this;
        }

        public Criteria andLfdTypeNotEqualTo(String value) {
            addCriterion("lfd_type <>", value, "lfdType");
            return (Criteria) this;
        }

        public Criteria andLfdTypeGreaterThan(String value) {
            addCriterion("lfd_type >", value, "lfdType");
            return (Criteria) this;
        }

        public Criteria andLfdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("lfd_type >=", value, "lfdType");
            return (Criteria) this;
        }

        public Criteria andLfdTypeLessThan(String value) {
            addCriterion("lfd_type <", value, "lfdType");
            return (Criteria) this;
        }

        public Criteria andLfdTypeLessThanOrEqualTo(String value) {
            addCriterion("lfd_type <=", value, "lfdType");
            return (Criteria) this;
        }

        public Criteria andLfdTypeLike(String value) {
            addCriterion("lfd_type like", value, "lfdType");
            return (Criteria) this;
        }

        public Criteria andLfdTypeNotLike(String value) {
            addCriterion("lfd_type not like", value, "lfdType");
            return (Criteria) this;
        }

        public Criteria andLfdTypeIn(List<String> values) {
            addCriterion("lfd_type in", values, "lfdType");
            return (Criteria) this;
        }

        public Criteria andLfdTypeNotIn(List<String> values) {
            addCriterion("lfd_type not in", values, "lfdType");
            return (Criteria) this;
        }

        public Criteria andLfdTypeBetween(String value1, String value2) {
            addCriterion("lfd_type between", value1, value2, "lfdType");
            return (Criteria) this;
        }

        public Criteria andLfdTypeNotBetween(String value1, String value2) {
            addCriterion("lfd_type not between", value1, value2, "lfdType");
            return (Criteria) this;
        }

        public Criteria andLfdExpressIsNull() {
            addCriterion("lfd_express is null");
            return (Criteria) this;
        }

        public Criteria andLfdExpressIsNotNull() {
            addCriterion("lfd_express is not null");
            return (Criteria) this;
        }

        public Criteria andLfdExpressEqualTo(String value) {
            addCriterion("lfd_express =", value, "lfdExpress");
            return (Criteria) this;
        }

        public Criteria andLfdExpressNotEqualTo(String value) {
            addCriterion("lfd_express <>", value, "lfdExpress");
            return (Criteria) this;
        }

        public Criteria andLfdExpressGreaterThan(String value) {
            addCriterion("lfd_express >", value, "lfdExpress");
            return (Criteria) this;
        }

        public Criteria andLfdExpressGreaterThanOrEqualTo(String value) {
            addCriterion("lfd_express >=", value, "lfdExpress");
            return (Criteria) this;
        }

        public Criteria andLfdExpressLessThan(String value) {
            addCriterion("lfd_express <", value, "lfdExpress");
            return (Criteria) this;
        }

        public Criteria andLfdExpressLessThanOrEqualTo(String value) {
            addCriterion("lfd_express <=", value, "lfdExpress");
            return (Criteria) this;
        }

        public Criteria andLfdExpressLike(String value) {
            addCriterion("lfd_express like", value, "lfdExpress");
            return (Criteria) this;
        }

        public Criteria andLfdExpressNotLike(String value) {
            addCriterion("lfd_express not like", value, "lfdExpress");
            return (Criteria) this;
        }

        public Criteria andLfdExpressIn(List<String> values) {
            addCriterion("lfd_express in", values, "lfdExpress");
            return (Criteria) this;
        }

        public Criteria andLfdExpressNotIn(List<String> values) {
            addCriterion("lfd_express not in", values, "lfdExpress");
            return (Criteria) this;
        }

        public Criteria andLfdExpressBetween(String value1, String value2) {
            addCriterion("lfd_express between", value1, value2, "lfdExpress");
            return (Criteria) this;
        }

        public Criteria andLfdExpressNotBetween(String value1, String value2) {
            addCriterion("lfd_express not between", value1, value2, "lfdExpress");
            return (Criteria) this;
        }

        public Criteria andLfdTbIdIsNull() {
            addCriterion("lfd_tb_id is null");
            return (Criteria) this;
        }

        public Criteria andLfdTbIdIsNotNull() {
            addCriterion("lfd_tb_id is not null");
            return (Criteria) this;
        }

        public Criteria andLfdTbIdEqualTo(String value) {
            addCriterion("lfd_tb_id =", value, "lfdTbId");
            return (Criteria) this;
        }

        public Criteria andLfdTbIdNotEqualTo(String value) {
            addCriterion("lfd_tb_id <>", value, "lfdTbId");
            return (Criteria) this;
        }

        public Criteria andLfdTbIdGreaterThan(String value) {
            addCriterion("lfd_tb_id >", value, "lfdTbId");
            return (Criteria) this;
        }

        public Criteria andLfdTbIdGreaterThanOrEqualTo(String value) {
            addCriterion("lfd_tb_id >=", value, "lfdTbId");
            return (Criteria) this;
        }

        public Criteria andLfdTbIdLessThan(String value) {
            addCriterion("lfd_tb_id <", value, "lfdTbId");
            return (Criteria) this;
        }

        public Criteria andLfdTbIdLessThanOrEqualTo(String value) {
            addCriterion("lfd_tb_id <=", value, "lfdTbId");
            return (Criteria) this;
        }

        public Criteria andLfdTbIdLike(String value) {
            addCriterion("lfd_tb_id like", value, "lfdTbId");
            return (Criteria) this;
        }

        public Criteria andLfdTbIdNotLike(String value) {
            addCriterion("lfd_tb_id not like", value, "lfdTbId");
            return (Criteria) this;
        }

        public Criteria andLfdTbIdIn(List<String> values) {
            addCriterion("lfd_tb_id in", values, "lfdTbId");
            return (Criteria) this;
        }

        public Criteria andLfdTbIdNotIn(List<String> values) {
            addCriterion("lfd_tb_id not in", values, "lfdTbId");
            return (Criteria) this;
        }

        public Criteria andLfdTbIdBetween(String value1, String value2) {
            addCriterion("lfd_tb_id between", value1, value2, "lfdTbId");
            return (Criteria) this;
        }

        public Criteria andLfdTbIdNotBetween(String value1, String value2) {
            addCriterion("lfd_tb_id not between", value1, value2, "lfdTbId");
            return (Criteria) this;
        }

        public Criteria andLfdDescIsNull() {
            addCriterion("lfd_desc is null");
            return (Criteria) this;
        }

        public Criteria andLfdDescIsNotNull() {
            addCriterion("lfd_desc is not null");
            return (Criteria) this;
        }

        public Criteria andLfdDescEqualTo(String value) {
            addCriterion("lfd_desc =", value, "lfdDesc");
            return (Criteria) this;
        }

        public Criteria andLfdDescNotEqualTo(String value) {
            addCriterion("lfd_desc <>", value, "lfdDesc");
            return (Criteria) this;
        }

        public Criteria andLfdDescGreaterThan(String value) {
            addCriterion("lfd_desc >", value, "lfdDesc");
            return (Criteria) this;
        }

        public Criteria andLfdDescGreaterThanOrEqualTo(String value) {
            addCriterion("lfd_desc >=", value, "lfdDesc");
            return (Criteria) this;
        }

        public Criteria andLfdDescLessThan(String value) {
            addCriterion("lfd_desc <", value, "lfdDesc");
            return (Criteria) this;
        }

        public Criteria andLfdDescLessThanOrEqualTo(String value) {
            addCriterion("lfd_desc <=", value, "lfdDesc");
            return (Criteria) this;
        }

        public Criteria andLfdDescLike(String value) {
            addCriterion("lfd_desc like", value, "lfdDesc");
            return (Criteria) this;
        }

        public Criteria andLfdDescNotLike(String value) {
            addCriterion("lfd_desc not like", value, "lfdDesc");
            return (Criteria) this;
        }

        public Criteria andLfdDescIn(List<String> values) {
            addCriterion("lfd_desc in", values, "lfdDesc");
            return (Criteria) this;
        }

        public Criteria andLfdDescNotIn(List<String> values) {
            addCriterion("lfd_desc not in", values, "lfdDesc");
            return (Criteria) this;
        }

        public Criteria andLfdDescBetween(String value1, String value2) {
            addCriterion("lfd_desc between", value1, value2, "lfdDesc");
            return (Criteria) this;
        }

        public Criteria andLfdDescNotBetween(String value1, String value2) {
            addCriterion("lfd_desc not between", value1, value2, "lfdDesc");
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