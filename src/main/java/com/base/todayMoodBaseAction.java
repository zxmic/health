package com.base;

import service.TodayMoodService;

public class todayMoodBaseAction {
    protected TodayMoodService todayMoodService;

    public TodayMoodService getTodayMoodService() {
        return todayMoodService;
    }

    public void setTodayMoodService(TodayMoodService todayMoodService) {
        this.todayMoodService = todayMoodService;
    }



}
