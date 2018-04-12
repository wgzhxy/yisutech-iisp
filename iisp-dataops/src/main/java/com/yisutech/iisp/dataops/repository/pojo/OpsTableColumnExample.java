package com.yisutech.iisp.dataops.repository.pojo;

import java.util.ArrayList;
import java.util.List;

public class OpsTableColumnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpsTableColumnExample() {
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

        public Criteria andTbIdIsNull() {
            addCriterion("tb_id is null");
            return (Criteria) this;
        }

        public Criteria andTbIdIsNotNull() {
            addCriterion("tb_id is not null");
            return (Criteria) this;
        }

        public Criteria andTbIdEqualTo(Integer value) {
            addCriterion("tb_id =", value, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdNotEqualTo(Integer value) {
            addCriterion("tb_id <>", value, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdGreaterThan(Integer value) {
            addCriterion("tb_id >", value, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tb_id >=", value, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdLessThan(Integer value) {
            addCriterion("tb_id <", value, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdLessThanOrEqualTo(Integer value) {
            addCriterion("tb_id <=", value, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdIn(List<Integer> values) {
            addCriterion("tb_id in", values, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdNotIn(List<Integer> values) {
            addCriterion("tb_id not in", values, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdBetween(Integer value1, Integer value2) {
            addCriterion("tb_id between", value1, value2, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tb_id not between", value1, value2, "tbId");
            return (Criteria) this;
        }

        public Criteria andFdNameIsNull() {
            addCriterion("fd_name is null");
            return (Criteria) this;
        }

        public Criteria andFdNameIsNotNull() {
            addCriterion("fd_name is not null");
            return (Criteria) this;
        }

        public Criteria andFdNameEqualTo(String value) {
            addCriterion("fd_name =", value, "fdName");
            return (Criteria) this;
        }

        public Criteria andFdNameNotEqualTo(String value) {
            addCriterion("fd_name <>", value, "fdName");
            return (Criteria) this;
        }

        public Criteria andFdNameGreaterThan(String value) {
            addCriterion("fd_name >", value, "fdName");
            return (Criteria) this;
        }

        public Criteria andFdNameGreaterThanOrEqualTo(String value) {
            addCriterion("fd_name >=", value, "fdName");
            return (Criteria) this;
        }

        public Criteria andFdNameLessThan(String value) {
            addCriterion("fd_name <", value, "fdName");
            return (Criteria) this;
        }

        public Criteria andFdNameLessThanOrEqualTo(String value) {
            addCriterion("fd_name <=", value, "fdName");
            return (Criteria) this;
        }

        public Criteria andFdNameLike(String value) {
            addCriterion("fd_name like", value, "fdName");
            return (Criteria) this;
        }

        public Criteria andFdNameNotLike(String value) {
            addCriterion("fd_name not like", value, "fdName");
            return (Criteria) this;
        }

        public Criteria andFdNameIn(List<String> values) {
            addCriterion("fd_name in", values, "fdName");
            return (Criteria) this;
        }

        public Criteria andFdNameNotIn(List<String> values) {
            addCriterion("fd_name not in", values, "fdName");
            return (Criteria) this;
        }

        public Criteria andFdNameBetween(String value1, String value2) {
            addCriterion("fd_name between", value1, value2, "fdName");
            return (Criteria) this;
        }

        public Criteria andFdNameNotBetween(String value1, String value2) {
            addCriterion("fd_name not between", value1, value2, "fdName");
            return (Criteria) this;
        }

        public Criteria andFdDescIsNull() {
            addCriterion("fd_desc is null");
            return (Criteria) this;
        }

        public Criteria andFdDescIsNotNull() {
            addCriterion("fd_desc is not null");
            return (Criteria) this;
        }

        public Criteria andFdDescEqualTo(String value) {
            addCriterion("fd_desc =", value, "fdDesc");
            return (Criteria) this;
        }

        public Criteria andFdDescNotEqualTo(String value) {
            addCriterion("fd_desc <>", value, "fdDesc");
            return (Criteria) this;
        }

        public Criteria andFdDescGreaterThan(String value) {
            addCriterion("fd_desc >", value, "fdDesc");
            return (Criteria) this;
        }

        public Criteria andFdDescGreaterThanOrEqualTo(String value) {
            addCriterion("fd_desc >=", value, "fdDesc");
            return (Criteria) this;
        }

        public Criteria andFdDescLessThan(String value) {
            addCriterion("fd_desc <", value, "fdDesc");
            return (Criteria) this;
        }

        public Criteria andFdDescLessThanOrEqualTo(String value) {
            addCriterion("fd_desc <=", value, "fdDesc");
            return (Criteria) this;
        }

        public Criteria andFdDescLike(String value) {
            addCriterion("fd_desc like", value, "fdDesc");
            return (Criteria) this;
        }

        public Criteria andFdDescNotLike(String value) {
            addCriterion("fd_desc not like", value, "fdDesc");
            return (Criteria) this;
        }

        public Criteria andFdDescIn(List<String> values) {
            addCriterion("fd_desc in", values, "fdDesc");
            return (Criteria) this;
        }

        public Criteria andFdDescNotIn(List<String> values) {
            addCriterion("fd_desc not in", values, "fdDesc");
            return (Criteria) this;
        }

        public Criteria andFdDescBetween(String value1, String value2) {
            addCriterion("fd_desc between", value1, value2, "fdDesc");
            return (Criteria) this;
        }

        public Criteria andFdDescNotBetween(String value1, String value2) {
            addCriterion("fd_desc not between", value1, value2, "fdDesc");
            return (Criteria) this;
        }

        public Criteria andFdTypeIsNull() {
            addCriterion("fd_type is null");
            return (Criteria) this;
        }

        public Criteria andFdTypeIsNotNull() {
            addCriterion("fd_type is not null");
            return (Criteria) this;
        }

        public Criteria andFdTypeEqualTo(String value) {
            addCriterion("fd_type =", value, "fdType");
            return (Criteria) this;
        }

        public Criteria andFdTypeNotEqualTo(String value) {
            addCriterion("fd_type <>", value, "fdType");
            return (Criteria) this;
        }

        public Criteria andFdTypeGreaterThan(String value) {
            addCriterion("fd_type >", value, "fdType");
            return (Criteria) this;
        }

        public Criteria andFdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fd_type >=", value, "fdType");
            return (Criteria) this;
        }

        public Criteria andFdTypeLessThan(String value) {
            addCriterion("fd_type <", value, "fdType");
            return (Criteria) this;
        }

        public Criteria andFdTypeLessThanOrEqualTo(String value) {
            addCriterion("fd_type <=", value, "fdType");
            return (Criteria) this;
        }

        public Criteria andFdTypeLike(String value) {
            addCriterion("fd_type like", value, "fdType");
            return (Criteria) this;
        }

        public Criteria andFdTypeNotLike(String value) {
            addCriterion("fd_type not like", value, "fdType");
            return (Criteria) this;
        }

        public Criteria andFdTypeIn(List<String> values) {
            addCriterion("fd_type in", values, "fdType");
            return (Criteria) this;
        }

        public Criteria andFdTypeNotIn(List<String> values) {
            addCriterion("fd_type not in", values, "fdType");
            return (Criteria) this;
        }

        public Criteria andFdTypeBetween(String value1, String value2) {
            addCriterion("fd_type between", value1, value2, "fdType");
            return (Criteria) this;
        }

        public Criteria andFdTypeNotBetween(String value1, String value2) {
            addCriterion("fd_type not between", value1, value2, "fdType");
            return (Criteria) this;
        }

        public Criteria andFdLengthIsNull() {
            addCriterion("fd_length is null");
            return (Criteria) this;
        }

        public Criteria andFdLengthIsNotNull() {
            addCriterion("fd_length is not null");
            return (Criteria) this;
        }

        public Criteria andFdLengthEqualTo(Integer value) {
            addCriterion("fd_length =", value, "fdLength");
            return (Criteria) this;
        }

        public Criteria andFdLengthNotEqualTo(Integer value) {
            addCriterion("fd_length <>", value, "fdLength");
            return (Criteria) this;
        }

        public Criteria andFdLengthGreaterThan(Integer value) {
            addCriterion("fd_length >", value, "fdLength");
            return (Criteria) this;
        }

        public Criteria andFdLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("fd_length >=", value, "fdLength");
            return (Criteria) this;
        }

        public Criteria andFdLengthLessThan(Integer value) {
            addCriterion("fd_length <", value, "fdLength");
            return (Criteria) this;
        }

        public Criteria andFdLengthLessThanOrEqualTo(Integer value) {
            addCriterion("fd_length <=", value, "fdLength");
            return (Criteria) this;
        }

        public Criteria andFdLengthIn(List<Integer> values) {
            addCriterion("fd_length in", values, "fdLength");
            return (Criteria) this;
        }

        public Criteria andFdLengthNotIn(List<Integer> values) {
            addCriterion("fd_length not in", values, "fdLength");
            return (Criteria) this;
        }

        public Criteria andFdLengthBetween(Integer value1, Integer value2) {
            addCriterion("fd_length between", value1, value2, "fdLength");
            return (Criteria) this;
        }

        public Criteria andFdLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("fd_length not between", value1, value2, "fdLength");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyIsNull() {
            addCriterion("fd_primary_key is null");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyIsNotNull() {
            addCriterion("fd_primary_key is not null");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyEqualTo(Boolean value) {
            addCriterion("fd_primary_key =", value, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyNotEqualTo(Boolean value) {
            addCriterion("fd_primary_key <>", value, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyGreaterThan(Boolean value) {
            addCriterion("fd_primary_key >", value, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("fd_primary_key >=", value, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyLessThan(Boolean value) {
            addCriterion("fd_primary_key <", value, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyLessThanOrEqualTo(Boolean value) {
            addCriterion("fd_primary_key <=", value, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyIn(List<Boolean> values) {
            addCriterion("fd_primary_key in", values, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyNotIn(List<Boolean> values) {
            addCriterion("fd_primary_key not in", values, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyBetween(Boolean value1, Boolean value2) {
            addCriterion("fd_primary_key between", value1, value2, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdPrimaryKeyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("fd_primary_key not between", value1, value2, "fdPrimaryKey");
            return (Criteria) this;
        }

        public Criteria andFdTagNullIsNull() {
            addCriterion("fd_tag_null is null");
            return (Criteria) this;
        }

        public Criteria andFdTagNullIsNotNull() {
            addCriterion("fd_tag_null is not null");
            return (Criteria) this;
        }

        public Criteria andFdTagNullEqualTo(Boolean value) {
            addCriterion("fd_tag_null =", value, "fdTagNull");
            return (Criteria) this;
        }

        public Criteria andFdTagNullNotEqualTo(Boolean value) {
            addCriterion("fd_tag_null <>", value, "fdTagNull");
            return (Criteria) this;
        }

        public Criteria andFdTagNullGreaterThan(Boolean value) {
            addCriterion("fd_tag_null >", value, "fdTagNull");
            return (Criteria) this;
        }

        public Criteria andFdTagNullGreaterThanOrEqualTo(Boolean value) {
            addCriterion("fd_tag_null >=", value, "fdTagNull");
            return (Criteria) this;
        }

        public Criteria andFdTagNullLessThan(Boolean value) {
            addCriterion("fd_tag_null <", value, "fdTagNull");
            return (Criteria) this;
        }

        public Criteria andFdTagNullLessThanOrEqualTo(Boolean value) {
            addCriterion("fd_tag_null <=", value, "fdTagNull");
            return (Criteria) this;
        }

        public Criteria andFdTagNullIn(List<Boolean> values) {
            addCriterion("fd_tag_null in", values, "fdTagNull");
            return (Criteria) this;
        }

        public Criteria andFdTagNullNotIn(List<Boolean> values) {
            addCriterion("fd_tag_null not in", values, "fdTagNull");
            return (Criteria) this;
        }

        public Criteria andFdTagNullBetween(Boolean value1, Boolean value2) {
            addCriterion("fd_tag_null between", value1, value2, "fdTagNull");
            return (Criteria) this;
        }

        public Criteria andFdTagNullNotBetween(Boolean value1, Boolean value2) {
            addCriterion("fd_tag_null not between", value1, value2, "fdTagNull");
            return (Criteria) this;
        }

        public Criteria andFdDefaultValueIsNull() {
            addCriterion("fd_default_value is null");
            return (Criteria) this;
        }

        public Criteria andFdDefaultValueIsNotNull() {
            addCriterion("fd_default_value is not null");
            return (Criteria) this;
        }

        public Criteria andFdDefaultValueEqualTo(String value) {
            addCriterion("fd_default_value =", value, "fdDefaultValue");
            return (Criteria) this;
        }

        public Criteria andFdDefaultValueNotEqualTo(String value) {
            addCriterion("fd_default_value <>", value, "fdDefaultValue");
            return (Criteria) this;
        }

        public Criteria andFdDefaultValueGreaterThan(String value) {
            addCriterion("fd_default_value >", value, "fdDefaultValue");
            return (Criteria) this;
        }

        public Criteria andFdDefaultValueGreaterThanOrEqualTo(String value) {
            addCriterion("fd_default_value >=", value, "fdDefaultValue");
            return (Criteria) this;
        }

        public Criteria andFdDefaultValueLessThan(String value) {
            addCriterion("fd_default_value <", value, "fdDefaultValue");
            return (Criteria) this;
        }

        public Criteria andFdDefaultValueLessThanOrEqualTo(String value) {
            addCriterion("fd_default_value <=", value, "fdDefaultValue");
            return (Criteria) this;
        }

        public Criteria andFdDefaultValueLike(String value) {
            addCriterion("fd_default_value like", value, "fdDefaultValue");
            return (Criteria) this;
        }

        public Criteria andFdDefaultValueNotLike(String value) {
            addCriterion("fd_default_value not like", value, "fdDefaultValue");
            return (Criteria) this;
        }

        public Criteria andFdDefaultValueIn(List<String> values) {
            addCriterion("fd_default_value in", values, "fdDefaultValue");
            return (Criteria) this;
        }

        public Criteria andFdDefaultValueNotIn(List<String> values) {
            addCriterion("fd_default_value not in", values, "fdDefaultValue");
            return (Criteria) this;
        }

        public Criteria andFdDefaultValueBetween(String value1, String value2) {
            addCriterion("fd_default_value between", value1, value2, "fdDefaultValue");
            return (Criteria) this;
        }

        public Criteria andFdDefaultValueNotBetween(String value1, String value2) {
            addCriterion("fd_default_value not between", value1, value2, "fdDefaultValue");
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