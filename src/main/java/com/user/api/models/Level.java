package com.user.api.models;

public enum Level {
  LOW("low"),
  MEDIUM("medium"),
  HIGHT("hight");

  private String description;

  Level(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }  
}
