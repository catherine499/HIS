package com.example.HIS.models;

import java.util.ArrayList;
import java.util.List;

public class DepartmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DepartmentExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("department_id like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("department_id not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("department_name not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentTelIsNull() {
            addCriterion("department_tel is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentTelIsNotNull() {
            addCriterion("department_tel is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentTelEqualTo(String value) {
            addCriterion("department_tel =", value, "departmentTel");
            return (Criteria) this;
        }

        public Criteria andDepartmentTelNotEqualTo(String value) {
            addCriterion("department_tel <>", value, "departmentTel");
            return (Criteria) this;
        }

        public Criteria andDepartmentTelGreaterThan(String value) {
            addCriterion("department_tel >", value, "departmentTel");
            return (Criteria) this;
        }

        public Criteria andDepartmentTelGreaterThanOrEqualTo(String value) {
            addCriterion("department_tel >=", value, "departmentTel");
            return (Criteria) this;
        }

        public Criteria andDepartmentTelLessThan(String value) {
            addCriterion("department_tel <", value, "departmentTel");
            return (Criteria) this;
        }

        public Criteria andDepartmentTelLessThanOrEqualTo(String value) {
            addCriterion("department_tel <=", value, "departmentTel");
            return (Criteria) this;
        }

        public Criteria andDepartmentTelLike(String value) {
            addCriterion("department_tel like", value, "departmentTel");
            return (Criteria) this;
        }

        public Criteria andDepartmentTelNotLike(String value) {
            addCriterion("department_tel not like", value, "departmentTel");
            return (Criteria) this;
        }

        public Criteria andDepartmentTelIn(List<String> values) {
            addCriterion("department_tel in", values, "departmentTel");
            return (Criteria) this;
        }

        public Criteria andDepartmentTelNotIn(List<String> values) {
            addCriterion("department_tel not in", values, "departmentTel");
            return (Criteria) this;
        }

        public Criteria andDepartmentTelBetween(String value1, String value2) {
            addCriterion("department_tel between", value1, value2, "departmentTel");
            return (Criteria) this;
        }

        public Criteria andDepartmentTelNotBetween(String value1, String value2) {
            addCriterion("department_tel not between", value1, value2, "departmentTel");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressIsNull() {
            addCriterion("department_address is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressIsNotNull() {
            addCriterion("department_address is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressEqualTo(String value) {
            addCriterion("department_address =", value, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressNotEqualTo(String value) {
            addCriterion("department_address <>", value, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressGreaterThan(String value) {
            addCriterion("department_address >", value, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressGreaterThanOrEqualTo(String value) {
            addCriterion("department_address >=", value, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressLessThan(String value) {
            addCriterion("department_address <", value, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressLessThanOrEqualTo(String value) {
            addCriterion("department_address <=", value, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressLike(String value) {
            addCriterion("department_address like", value, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressNotLike(String value) {
            addCriterion("department_address not like", value, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressIn(List<String> values) {
            addCriterion("department_address in", values, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressNotIn(List<String> values) {
            addCriterion("department_address not in", values, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressBetween(String value1, String value2) {
            addCriterion("department_address between", value1, value2, "departmentAddress");
            return (Criteria) this;
        }

        public Criteria andDepartmentAddressNotBetween(String value1, String value2) {
            addCriterion("department_address not between", value1, value2, "departmentAddress");
            return (Criteria) this;
        }
    }

    /**
     */
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