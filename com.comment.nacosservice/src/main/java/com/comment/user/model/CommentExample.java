package com.comment.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRevieweridIsNull() {
            addCriterion("reviewerID is null");
            return (Criteria) this;
        }

        public Criteria andRevieweridIsNotNull() {
            addCriterion("reviewerID is not null");
            return (Criteria) this;
        }

        public Criteria andRevieweridEqualTo(String value) {
            addCriterion("reviewerID =", value, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridNotEqualTo(String value) {
            addCriterion("reviewerID <>", value, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridGreaterThan(String value) {
            addCriterion("reviewerID >", value, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridGreaterThanOrEqualTo(String value) {
            addCriterion("reviewerID >=", value, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridLessThan(String value) {
            addCriterion("reviewerID <", value, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridLessThanOrEqualTo(String value) {
            addCriterion("reviewerID <=", value, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridLike(String value) {
            addCriterion("reviewerID like", value, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridNotLike(String value) {
            addCriterion("reviewerID not like", value, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridIn(List<String> values) {
            addCriterion("reviewerID in", values, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridNotIn(List<String> values) {
            addCriterion("reviewerID not in", values, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridBetween(String value1, String value2) {
            addCriterion("reviewerID between", value1, value2, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andRevieweridNotBetween(String value1, String value2) {
            addCriterion("reviewerID not between", value1, value2, "reviewerid");
            return (Criteria) this;
        }

        public Criteria andAsinIsNull() {
            addCriterion("asin is null");
            return (Criteria) this;
        }

        public Criteria andAsinIsNotNull() {
            addCriterion("asin is not null");
            return (Criteria) this;
        }

        public Criteria andAsinEqualTo(String value) {
            addCriterion("asin =", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinNotEqualTo(String value) {
            addCriterion("asin <>", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinGreaterThan(String value) {
            addCriterion("asin >", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinGreaterThanOrEqualTo(String value) {
            addCriterion("asin >=", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinLessThan(String value) {
            addCriterion("asin <", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinLessThanOrEqualTo(String value) {
            addCriterion("asin <=", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinLike(String value) {
            addCriterion("asin like", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinNotLike(String value) {
            addCriterion("asin not like", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinIn(List<String> values) {
            addCriterion("asin in", values, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinNotIn(List<String> values) {
            addCriterion("asin not in", values, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinBetween(String value1, String value2) {
            addCriterion("asin between", value1, value2, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinNotBetween(String value1, String value2) {
            addCriterion("asin not between", value1, value2, "asin");
            return (Criteria) this;
        }

        public Criteria andReviewernameIsNull() {
            addCriterion("reviewerName is null");
            return (Criteria) this;
        }

        public Criteria andReviewernameIsNotNull() {
            addCriterion("reviewerName is not null");
            return (Criteria) this;
        }

        public Criteria andReviewernameEqualTo(String value) {
            addCriterion("reviewerName =", value, "reviewername");
            return (Criteria) this;
        }

        public Criteria andReviewernameNotEqualTo(String value) {
            addCriterion("reviewerName <>", value, "reviewername");
            return (Criteria) this;
        }

        public Criteria andReviewernameGreaterThan(String value) {
            addCriterion("reviewerName >", value, "reviewername");
            return (Criteria) this;
        }

        public Criteria andReviewernameGreaterThanOrEqualTo(String value) {
            addCriterion("reviewerName >=", value, "reviewername");
            return (Criteria) this;
        }

        public Criteria andReviewernameLessThan(String value) {
            addCriterion("reviewerName <", value, "reviewername");
            return (Criteria) this;
        }

        public Criteria andReviewernameLessThanOrEqualTo(String value) {
            addCriterion("reviewerName <=", value, "reviewername");
            return (Criteria) this;
        }

        public Criteria andReviewernameLike(String value) {
            addCriterion("reviewerName like", value, "reviewername");
            return (Criteria) this;
        }

        public Criteria andReviewernameNotLike(String value) {
            addCriterion("reviewerName not like", value, "reviewername");
            return (Criteria) this;
        }

        public Criteria andReviewernameIn(List<String> values) {
            addCriterion("reviewerName in", values, "reviewername");
            return (Criteria) this;
        }

        public Criteria andReviewernameNotIn(List<String> values) {
            addCriterion("reviewerName not in", values, "reviewername");
            return (Criteria) this;
        }

        public Criteria andReviewernameBetween(String value1, String value2) {
            addCriterion("reviewerName between", value1, value2, "reviewername");
            return (Criteria) this;
        }

        public Criteria andReviewernameNotBetween(String value1, String value2) {
            addCriterion("reviewerName not between", value1, value2, "reviewername");
            return (Criteria) this;
        }

        public Criteria andHelpfulIsNull() {
            addCriterion("helpful is null");
            return (Criteria) this;
        }

        public Criteria andHelpfulIsNotNull() {
            addCriterion("helpful is not null");
            return (Criteria) this;
        }

        public Criteria andHelpfulEqualTo(String value) {
            addCriterion("helpful =", value, "helpful");
            return (Criteria) this;
        }

        public Criteria andHelpfulNotEqualTo(String value) {
            addCriterion("helpful <>", value, "helpful");
            return (Criteria) this;
        }

        public Criteria andHelpfulGreaterThan(String value) {
            addCriterion("helpful >", value, "helpful");
            return (Criteria) this;
        }

        public Criteria andHelpfulGreaterThanOrEqualTo(String value) {
            addCriterion("helpful >=", value, "helpful");
            return (Criteria) this;
        }

        public Criteria andHelpfulLessThan(String value) {
            addCriterion("helpful <", value, "helpful");
            return (Criteria) this;
        }

        public Criteria andHelpfulLessThanOrEqualTo(String value) {
            addCriterion("helpful <=", value, "helpful");
            return (Criteria) this;
        }

        public Criteria andHelpfulLike(String value) {
            addCriterion("helpful like", value, "helpful");
            return (Criteria) this;
        }

        public Criteria andHelpfulNotLike(String value) {
            addCriterion("helpful not like", value, "helpful");
            return (Criteria) this;
        }

        public Criteria andHelpfulIn(List<String> values) {
            addCriterion("helpful in", values, "helpful");
            return (Criteria) this;
        }

        public Criteria andHelpfulNotIn(List<String> values) {
            addCriterion("helpful not in", values, "helpful");
            return (Criteria) this;
        }

        public Criteria andHelpfulBetween(String value1, String value2) {
            addCriterion("helpful between", value1, value2, "helpful");
            return (Criteria) this;
        }

        public Criteria andHelpfulNotBetween(String value1, String value2) {
            addCriterion("helpful not between", value1, value2, "helpful");
            return (Criteria) this;
        }

        public Criteria andReviewtextIsNull() {
            addCriterion("reviewText is null");
            return (Criteria) this;
        }

        public Criteria andReviewtextIsNotNull() {
            addCriterion("reviewText is not null");
            return (Criteria) this;
        }

        public Criteria andReviewtextEqualTo(String value) {
            addCriterion("reviewText =", value, "reviewtext");
            return (Criteria) this;
        }

        public Criteria andReviewtextNotEqualTo(String value) {
            addCriterion("reviewText <>", value, "reviewtext");
            return (Criteria) this;
        }

        public Criteria andReviewtextGreaterThan(String value) {
            addCriterion("reviewText >", value, "reviewtext");
            return (Criteria) this;
        }

        public Criteria andReviewtextGreaterThanOrEqualTo(String value) {
            addCriterion("reviewText >=", value, "reviewtext");
            return (Criteria) this;
        }

        public Criteria andReviewtextLessThan(String value) {
            addCriterion("reviewText <", value, "reviewtext");
            return (Criteria) this;
        }

        public Criteria andReviewtextLessThanOrEqualTo(String value) {
            addCriterion("reviewText <=", value, "reviewtext");
            return (Criteria) this;
        }

        public Criteria andReviewtextLike(String value) {
            addCriterion("reviewText like", value, "reviewtext");
            return (Criteria) this;
        }

        public Criteria andReviewtextNotLike(String value) {
            addCriterion("reviewText not like", value, "reviewtext");
            return (Criteria) this;
        }

        public Criteria andReviewtextIn(List<String> values) {
            addCriterion("reviewText in", values, "reviewtext");
            return (Criteria) this;
        }

        public Criteria andReviewtextNotIn(List<String> values) {
            addCriterion("reviewText not in", values, "reviewtext");
            return (Criteria) this;
        }

        public Criteria andReviewtextBetween(String value1, String value2) {
            addCriterion("reviewText between", value1, value2, "reviewtext");
            return (Criteria) this;
        }

        public Criteria andReviewtextNotBetween(String value1, String value2) {
            addCriterion("reviewText not between", value1, value2, "reviewtext");
            return (Criteria) this;
        }

        public Criteria andOverallIsNull() {
            addCriterion("overall is null");
            return (Criteria) this;
        }

        public Criteria andOverallIsNotNull() {
            addCriterion("overall is not null");
            return (Criteria) this;
        }

        public Criteria andOverallEqualTo(String value) {
            addCriterion("overall =", value, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallNotEqualTo(String value) {
            addCriterion("overall <>", value, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallGreaterThan(String value) {
            addCriterion("overall >", value, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallGreaterThanOrEqualTo(String value) {
            addCriterion("overall >=", value, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallLessThan(String value) {
            addCriterion("overall <", value, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallLessThanOrEqualTo(String value) {
            addCriterion("overall <=", value, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallLike(String value) {
            addCriterion("overall like", value, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallNotLike(String value) {
            addCriterion("overall not like", value, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallIn(List<String> values) {
            addCriterion("overall in", values, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallNotIn(List<String> values) {
            addCriterion("overall not in", values, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallBetween(String value1, String value2) {
            addCriterion("overall between", value1, value2, "overall");
            return (Criteria) this;
        }

        public Criteria andOverallNotBetween(String value1, String value2) {
            addCriterion("overall not between", value1, value2, "overall");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andUnixreviewtimeIsNull() {
            addCriterion("unixReviewTime is null");
            return (Criteria) this;
        }

        public Criteria andUnixreviewtimeIsNotNull() {
            addCriterion("unixReviewTime is not null");
            return (Criteria) this;
        }

        public Criteria andUnixreviewtimeEqualTo(Date value) {
            addCriterion("unixReviewTime =", value, "unixreviewtime");
            return (Criteria) this;
        }

        public Criteria andUnixreviewtimeNotEqualTo(Date value) {
            addCriterion("unixReviewTime <>", value, "unixreviewtime");
            return (Criteria) this;
        }

        public Criteria andUnixreviewtimeGreaterThan(Date value) {
            addCriterion("unixReviewTime >", value, "unixreviewtime");
            return (Criteria) this;
        }

        public Criteria andUnixreviewtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("unixReviewTime >=", value, "unixreviewtime");
            return (Criteria) this;
        }

        public Criteria andUnixreviewtimeLessThan(Date value) {
            addCriterion("unixReviewTime <", value, "unixreviewtime");
            return (Criteria) this;
        }

        public Criteria andUnixreviewtimeLessThanOrEqualTo(Date value) {
            addCriterion("unixReviewTime <=", value, "unixreviewtime");
            return (Criteria) this;
        }

        public Criteria andUnixreviewtimeIn(List<Date> values) {
            addCriterion("unixReviewTime in", values, "unixreviewtime");
            return (Criteria) this;
        }

        public Criteria andUnixreviewtimeNotIn(List<Date> values) {
            addCriterion("unixReviewTime not in", values, "unixreviewtime");
            return (Criteria) this;
        }

        public Criteria andUnixreviewtimeBetween(Date value1, Date value2) {
            addCriterion("unixReviewTime between", value1, value2, "unixreviewtime");
            return (Criteria) this;
        }

        public Criteria andUnixreviewtimeNotBetween(Date value1, Date value2) {
            addCriterion("unixReviewTime not between", value1, value2, "unixreviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeIsNull() {
            addCriterion("reviewTime is null");
            return (Criteria) this;
        }

        public Criteria andReviewtimeIsNotNull() {
            addCriterion("reviewTime is not null");
            return (Criteria) this;
        }

        public Criteria andReviewtimeEqualTo(Date value) {
            addCriterionForJDBCDate("reviewTime =", value, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("reviewTime <>", value, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("reviewTime >", value, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("reviewTime >=", value, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeLessThan(Date value) {
            addCriterionForJDBCDate("reviewTime <", value, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("reviewTime <=", value, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeIn(List<Date> values) {
            addCriterionForJDBCDate("reviewTime in", values, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("reviewTime not in", values, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("reviewTime between", value1, value2, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("reviewTime not between", value1, value2, "reviewtime");
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