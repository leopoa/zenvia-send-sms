package com.zenvia.zenviaapi;


import java.util.Random;

public class Sms {

    private String from;
    private Long to;
    private String msg;
    private String id;

    // private String callbackOption;
    // private String aggregateId;
    // private String schedule;

    public Sms(Builder builder){
        this.from = builder.from;
        this.to = builder.to;
        this.msg = builder.msg;
        this.id = builder.id == null ? String.valueOf(new Random().nextInt()) :  builder.id ;
       // this.callbackOption = builder.callbackOption;
       // this.schedule = builder.schedule;
       // this.aggregateId = builder.aggregateId;
    }

    public String getFrom() {
        return from;
    }

    public Long getTo() {
        return to;
    }

    public String getMsg() {
        return msg;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", msg='" + msg + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public static class Builder{
        private String from;
        private Long to;
        private String schedule;
        private String msg;
        private String callbackOption;
        private String id;
        private String aggregateId;

        public Builder() {
        }

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder to(Long to) {
            this.to = to;
            return this;
        }

        public Builder schedule(String schedule) {
            this.schedule = schedule;
            return this;
        }

        public Builder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder callbackOption(String callbackOption) {
            this.callbackOption = callbackOption;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder aggregateId(String aggregateId) {
            this.aggregateId = aggregateId;
            return this;
        }

        public Sms build(){
            return new Sms(this);
        }

    }
}

