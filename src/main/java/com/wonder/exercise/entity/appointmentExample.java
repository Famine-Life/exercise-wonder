package com.wonder.exercise.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class appointmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public appointmentExample() {
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

        public Criteria andRequestUserIdIsNull() {
            addCriterion("request_user_id is null");
            return (Criteria) this;
        }

        public Criteria andRequestUserIdIsNotNull() {
            addCriterion("request_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andRequestUserIdEqualTo(Integer value) {
            addCriterion("request_user_id =", value, "requestUserId");
            return (Criteria) this;
        }

        public Criteria andRequestUserIdNotEqualTo(Integer value) {
            addCriterion("request_user_id <>", value, "requestUserId");
            return (Criteria) this;
        }

        public Criteria andRequestUserIdGreaterThan(Integer value) {
            addCriterion("request_user_id >", value, "requestUserId");
            return (Criteria) this;
        }

        public Criteria andRequestUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("request_user_id >=", value, "requestUserId");
            return (Criteria) this;
        }

        public Criteria andRequestUserIdLessThan(Integer value) {
            addCriterion("request_user_id <", value, "requestUserId");
            return (Criteria) this;
        }

        public Criteria andRequestUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("request_user_id <=", value, "requestUserId");
            return (Criteria) this;
        }

        public Criteria andRequestUserIdIn(List<Integer> values) {
            addCriterion("request_user_id in", values, "requestUserId");
            return (Criteria) this;
        }

        public Criteria andRequestUserIdNotIn(List<Integer> values) {
            addCriterion("request_user_id not in", values, "requestUserId");
            return (Criteria) this;
        }

        public Criteria andRequestUserIdBetween(Integer value1, Integer value2) {
            addCriterion("request_user_id between", value1, value2, "requestUserId");
            return (Criteria) this;
        }

        public Criteria andRequestUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("request_user_id not between", value1, value2, "requestUserId");
            return (Criteria) this;
        }

        public Criteria andRequestedUserIdIsNull() {
            addCriterion("requested__user_id is null");
            return (Criteria) this;
        }

        public Criteria andRequestedUserIdIsNotNull() {
            addCriterion("requested__user_id is not null");
            return (Criteria) this;
        }

        public Criteria andRequestedUserIdEqualTo(Integer value) {
            addCriterion("requested__user_id =", value, "requestedUserId");
            return (Criteria) this;
        }

        public Criteria andRequestedUserIdNotEqualTo(Integer value) {
            addCriterion("requested__user_id <>", value, "requestedUserId");
            return (Criteria) this;
        }

        public Criteria andRequestedUserIdGreaterThan(Integer value) {
            addCriterion("requested__user_id >", value, "requestedUserId");
            return (Criteria) this;
        }

        public Criteria andRequestedUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("requested__user_id >=", value, "requestedUserId");
            return (Criteria) this;
        }

        public Criteria andRequestedUserIdLessThan(Integer value) {
            addCriterion("requested__user_id <", value, "requestedUserId");
            return (Criteria) this;
        }

        public Criteria andRequestedUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("requested__user_id <=", value, "requestedUserId");
            return (Criteria) this;
        }

        public Criteria andRequestedUserIdIn(List<Integer> values) {
            addCriterion("requested__user_id in", values, "requestedUserId");
            return (Criteria) this;
        }

        public Criteria andRequestedUserIdNotIn(List<Integer> values) {
            addCriterion("requested__user_id not in", values, "requestedUserId");
            return (Criteria) this;
        }

        public Criteria andRequestedUserIdBetween(Integer value1, Integer value2) {
            addCriterion("requested__user_id between", value1, value2, "requestedUserId");
            return (Criteria) this;
        }

        public Criteria andRequestedUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("requested__user_id not between", value1, value2, "requestedUserId");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeIsNull() {
            addCriterion("appointment_time is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeIsNotNull() {
            addCriterion("appointment_time is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeEqualTo(Date value) {
            addCriterion("appointment_time =", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeNotEqualTo(Date value) {
            addCriterion("appointment_time <>", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeGreaterThan(Date value) {
            addCriterion("appointment_time >", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("appointment_time >=", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeLessThan(Date value) {
            addCriterion("appointment_time <", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeLessThanOrEqualTo(Date value) {
            addCriterion("appointment_time <=", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeIn(List<Date> values) {
            addCriterion("appointment_time in", values, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeNotIn(List<Date> values) {
            addCriterion("appointment_time not in", values, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeBetween(Date value1, Date value2) {
            addCriterion("appointment_time between", value1, value2, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeNotBetween(Date value1, Date value2) {
            addCriterion("appointment_time not between", value1, value2, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNull() {
            addCriterion("request_time is null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNotNull() {
            addCriterion("request_time is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeEqualTo(Date value) {
            addCriterion("request_time =", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotEqualTo(Date value) {
            addCriterion("request_time <>", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThan(Date value) {
            addCriterion("request_time >", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("request_time >=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThan(Date value) {
            addCriterion("request_time <", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThanOrEqualTo(Date value) {
            addCriterion("request_time <=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIn(List<Date> values) {
            addCriterion("request_time in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotIn(List<Date> values) {
            addCriterion("request_time not in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeBetween(Date value1, Date value2) {
            addCriterion("request_time between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotBetween(Date value1, Date value2) {
            addCriterion("request_time not between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andAcceptIsNull() {
            addCriterion("accept is null");
            return (Criteria) this;
        }

        public Criteria andAcceptIsNotNull() {
            addCriterion("accept is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptEqualTo(Integer value) {
            addCriterion("accept =", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotEqualTo(Integer value) {
            addCriterion("accept <>", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptGreaterThan(Integer value) {
            addCriterion("accept >", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptGreaterThanOrEqualTo(Integer value) {
            addCriterion("accept >=", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptLessThan(Integer value) {
            addCriterion("accept <", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptLessThanOrEqualTo(Integer value) {
            addCriterion("accept <=", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptIn(List<Integer> values) {
            addCriterion("accept in", values, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotIn(List<Integer> values) {
            addCriterion("accept not in", values, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptBetween(Integer value1, Integer value2) {
            addCriterion("accept between", value1, value2, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotBetween(Integer value1, Integer value2) {
            addCriterion("accept not between", value1, value2, "accept");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Integer value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Integer value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Integer value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Integer value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Integer> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Integer> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
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