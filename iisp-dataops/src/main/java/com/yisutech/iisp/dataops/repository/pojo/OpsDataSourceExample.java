package com.yisutech.iisp.dataops.repository.pojo;

import java.util.ArrayList;
import java.util.List;

public class OpsDataSourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpsDataSourceExample() {
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

        public Criteria andDsUrlIsNull() {
            addCriterion("ds_url is null");
            return (Criteria) this;
        }

        public Criteria andDsUrlIsNotNull() {
            addCriterion("ds_url is not null");
            return (Criteria) this;
        }

        public Criteria andDsUrlEqualTo(String value) {
            addCriterion("ds_url =", value, "dsUrl");
            return (Criteria) this;
        }

        public Criteria andDsUrlNotEqualTo(String value) {
            addCriterion("ds_url <>", value, "dsUrl");
            return (Criteria) this;
        }

        public Criteria andDsUrlGreaterThan(String value) {
            addCriterion("ds_url >", value, "dsUrl");
            return (Criteria) this;
        }

        public Criteria andDsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ds_url >=", value, "dsUrl");
            return (Criteria) this;
        }

        public Criteria andDsUrlLessThan(String value) {
            addCriterion("ds_url <", value, "dsUrl");
            return (Criteria) this;
        }

        public Criteria andDsUrlLessThanOrEqualTo(String value) {
            addCriterion("ds_url <=", value, "dsUrl");
            return (Criteria) this;
        }

        public Criteria andDsUrlLike(String value) {
            addCriterion("ds_url like", value, "dsUrl");
            return (Criteria) this;
        }

        public Criteria andDsUrlNotLike(String value) {
            addCriterion("ds_url not like", value, "dsUrl");
            return (Criteria) this;
        }

        public Criteria andDsUrlIn(List<String> values) {
            addCriterion("ds_url in", values, "dsUrl");
            return (Criteria) this;
        }

        public Criteria andDsUrlNotIn(List<String> values) {
            addCriterion("ds_url not in", values, "dsUrl");
            return (Criteria) this;
        }

        public Criteria andDsUrlBetween(String value1, String value2) {
            addCriterion("ds_url between", value1, value2, "dsUrl");
            return (Criteria) this;
        }

        public Criteria andDsUrlNotBetween(String value1, String value2) {
            addCriterion("ds_url not between", value1, value2, "dsUrl");
            return (Criteria) this;
        }

        public Criteria andDsUserIsNull() {
            addCriterion("ds_user is null");
            return (Criteria) this;
        }

        public Criteria andDsUserIsNotNull() {
            addCriterion("ds_user is not null");
            return (Criteria) this;
        }

        public Criteria andDsUserEqualTo(String value) {
            addCriterion("ds_user =", value, "dsUser");
            return (Criteria) this;
        }

        public Criteria andDsUserNotEqualTo(String value) {
            addCriterion("ds_user <>", value, "dsUser");
            return (Criteria) this;
        }

        public Criteria andDsUserGreaterThan(String value) {
            addCriterion("ds_user >", value, "dsUser");
            return (Criteria) this;
        }

        public Criteria andDsUserGreaterThanOrEqualTo(String value) {
            addCriterion("ds_user >=", value, "dsUser");
            return (Criteria) this;
        }

        public Criteria andDsUserLessThan(String value) {
            addCriterion("ds_user <", value, "dsUser");
            return (Criteria) this;
        }

        public Criteria andDsUserLessThanOrEqualTo(String value) {
            addCriterion("ds_user <=", value, "dsUser");
            return (Criteria) this;
        }

        public Criteria andDsUserLike(String value) {
            addCriterion("ds_user like", value, "dsUser");
            return (Criteria) this;
        }

        public Criteria andDsUserNotLike(String value) {
            addCriterion("ds_user not like", value, "dsUser");
            return (Criteria) this;
        }

        public Criteria andDsUserIn(List<String> values) {
            addCriterion("ds_user in", values, "dsUser");
            return (Criteria) this;
        }

        public Criteria andDsUserNotIn(List<String> values) {
            addCriterion("ds_user not in", values, "dsUser");
            return (Criteria) this;
        }

        public Criteria andDsUserBetween(String value1, String value2) {
            addCriterion("ds_user between", value1, value2, "dsUser");
            return (Criteria) this;
        }

        public Criteria andDsUserNotBetween(String value1, String value2) {
            addCriterion("ds_user not between", value1, value2, "dsUser");
            return (Criteria) this;
        }

        public Criteria andDsPasswordIsNull() {
            addCriterion("ds_password is null");
            return (Criteria) this;
        }

        public Criteria andDsPasswordIsNotNull() {
            addCriterion("ds_password is not null");
            return (Criteria) this;
        }

        public Criteria andDsPasswordEqualTo(String value) {
            addCriterion("ds_password =", value, "dsPassword");
            return (Criteria) this;
        }

        public Criteria andDsPasswordNotEqualTo(String value) {
            addCriterion("ds_password <>", value, "dsPassword");
            return (Criteria) this;
        }

        public Criteria andDsPasswordGreaterThan(String value) {
            addCriterion("ds_password >", value, "dsPassword");
            return (Criteria) this;
        }

        public Criteria andDsPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("ds_password >=", value, "dsPassword");
            return (Criteria) this;
        }

        public Criteria andDsPasswordLessThan(String value) {
            addCriterion("ds_password <", value, "dsPassword");
            return (Criteria) this;
        }

        public Criteria andDsPasswordLessThanOrEqualTo(String value) {
            addCriterion("ds_password <=", value, "dsPassword");
            return (Criteria) this;
        }

        public Criteria andDsPasswordLike(String value) {
            addCriterion("ds_password like", value, "dsPassword");
            return (Criteria) this;
        }

        public Criteria andDsPasswordNotLike(String value) {
            addCriterion("ds_password not like", value, "dsPassword");
            return (Criteria) this;
        }

        public Criteria andDsPasswordIn(List<String> values) {
            addCriterion("ds_password in", values, "dsPassword");
            return (Criteria) this;
        }

        public Criteria andDsPasswordNotIn(List<String> values) {
            addCriterion("ds_password not in", values, "dsPassword");
            return (Criteria) this;
        }

        public Criteria andDsPasswordBetween(String value1, String value2) {
            addCriterion("ds_password between", value1, value2, "dsPassword");
            return (Criteria) this;
        }

        public Criteria andDsPasswordNotBetween(String value1, String value2) {
            addCriterion("ds_password not between", value1, value2, "dsPassword");
            return (Criteria) this;
        }

        public Criteria andDsNameIsNull() {
            addCriterion("ds_name is null");
            return (Criteria) this;
        }

        public Criteria andDsNameIsNotNull() {
            addCriterion("ds_name is not null");
            return (Criteria) this;
        }

        public Criteria andDsNameEqualTo(String value) {
            addCriterion("ds_name =", value, "dsName");
            return (Criteria) this;
        }

        public Criteria andDsNameNotEqualTo(String value) {
            addCriterion("ds_name <>", value, "dsName");
            return (Criteria) this;
        }

        public Criteria andDsNameGreaterThan(String value) {
            addCriterion("ds_name >", value, "dsName");
            return (Criteria) this;
        }

        public Criteria andDsNameGreaterThanOrEqualTo(String value) {
            addCriterion("ds_name >=", value, "dsName");
            return (Criteria) this;
        }

        public Criteria andDsNameLessThan(String value) {
            addCriterion("ds_name <", value, "dsName");
            return (Criteria) this;
        }

        public Criteria andDsNameLessThanOrEqualTo(String value) {
            addCriterion("ds_name <=", value, "dsName");
            return (Criteria) this;
        }

        public Criteria andDsNameLike(String value) {
            addCriterion("ds_name like", value, "dsName");
            return (Criteria) this;
        }

        public Criteria andDsNameNotLike(String value) {
            addCriterion("ds_name not like", value, "dsName");
            return (Criteria) this;
        }

        public Criteria andDsNameIn(List<String> values) {
            addCriterion("ds_name in", values, "dsName");
            return (Criteria) this;
        }

        public Criteria andDsNameNotIn(List<String> values) {
            addCriterion("ds_name not in", values, "dsName");
            return (Criteria) this;
        }

        public Criteria andDsNameBetween(String value1, String value2) {
            addCriterion("ds_name between", value1, value2, "dsName");
            return (Criteria) this;
        }

        public Criteria andDsNameNotBetween(String value1, String value2) {
            addCriterion("ds_name not between", value1, value2, "dsName");
            return (Criteria) this;
        }

        public Criteria andDsDescIsNull() {
            addCriterion("ds_desc is null");
            return (Criteria) this;
        }

        public Criteria andDsDescIsNotNull() {
            addCriterion("ds_desc is not null");
            return (Criteria) this;
        }

        public Criteria andDsDescEqualTo(String value) {
            addCriterion("ds_desc =", value, "dsDesc");
            return (Criteria) this;
        }

        public Criteria andDsDescNotEqualTo(String value) {
            addCriterion("ds_desc <>", value, "dsDesc");
            return (Criteria) this;
        }

        public Criteria andDsDescGreaterThan(String value) {
            addCriterion("ds_desc >", value, "dsDesc");
            return (Criteria) this;
        }

        public Criteria andDsDescGreaterThanOrEqualTo(String value) {
            addCriterion("ds_desc >=", value, "dsDesc");
            return (Criteria) this;
        }

        public Criteria andDsDescLessThan(String value) {
            addCriterion("ds_desc <", value, "dsDesc");
            return (Criteria) this;
        }

        public Criteria andDsDescLessThanOrEqualTo(String value) {
            addCriterion("ds_desc <=", value, "dsDesc");
            return (Criteria) this;
        }

        public Criteria andDsDescLike(String value) {
            addCriterion("ds_desc like", value, "dsDesc");
            return (Criteria) this;
        }

        public Criteria andDsDescNotLike(String value) {
            addCriterion("ds_desc not like", value, "dsDesc");
            return (Criteria) this;
        }

        public Criteria andDsDescIn(List<String> values) {
            addCriterion("ds_desc in", values, "dsDesc");
            return (Criteria) this;
        }

        public Criteria andDsDescNotIn(List<String> values) {
            addCriterion("ds_desc not in", values, "dsDesc");
            return (Criteria) this;
        }

        public Criteria andDsDescBetween(String value1, String value2) {
            addCriterion("ds_desc between", value1, value2, "dsDesc");
            return (Criteria) this;
        }

        public Criteria andDsDescNotBetween(String value1, String value2) {
            addCriterion("ds_desc not between", value1, value2, "dsDesc");
            return (Criteria) this;
        }

        public Criteria andDsTypeIsNull() {
            addCriterion("ds_type is null");
            return (Criteria) this;
        }

        public Criteria andDsTypeIsNotNull() {
            addCriterion("ds_type is not null");
            return (Criteria) this;
        }

        public Criteria andDsTypeEqualTo(String value) {
            addCriterion("ds_type =", value, "dsType");
            return (Criteria) this;
        }

        public Criteria andDsTypeNotEqualTo(String value) {
            addCriterion("ds_type <>", value, "dsType");
            return (Criteria) this;
        }

        public Criteria andDsTypeGreaterThan(String value) {
            addCriterion("ds_type >", value, "dsType");
            return (Criteria) this;
        }

        public Criteria andDsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ds_type >=", value, "dsType");
            return (Criteria) this;
        }

        public Criteria andDsTypeLessThan(String value) {
            addCriterion("ds_type <", value, "dsType");
            return (Criteria) this;
        }

        public Criteria andDsTypeLessThanOrEqualTo(String value) {
            addCriterion("ds_type <=", value, "dsType");
            return (Criteria) this;
        }

        public Criteria andDsTypeLike(String value) {
            addCriterion("ds_type like", value, "dsType");
            return (Criteria) this;
        }

        public Criteria andDsTypeNotLike(String value) {
            addCriterion("ds_type not like", value, "dsType");
            return (Criteria) this;
        }

        public Criteria andDsTypeIn(List<String> values) {
            addCriterion("ds_type in", values, "dsType");
            return (Criteria) this;
        }

        public Criteria andDsTypeNotIn(List<String> values) {
            addCriterion("ds_type not in", values, "dsType");
            return (Criteria) this;
        }

        public Criteria andDsTypeBetween(String value1, String value2) {
            addCriterion("ds_type between", value1, value2, "dsType");
            return (Criteria) this;
        }

        public Criteria andDsTypeNotBetween(String value1, String value2) {
            addCriterion("ds_type not between", value1, value2, "dsType");
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