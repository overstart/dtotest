package com.dtotest.demo.dto;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by liyf
 **/
public class SomeDto {

  private Boolean booleanObject;
  private Byte byteObject;
  private Character characterObject;
  private Double doubleObject;
  private Float floatObject;
  private Integer intObject;
  private Long longObject;
  private Short shortObject;
  private boolean primitiveBoolean;
  private byte primitiveByte;
  private char primitiveCharacter;
  private double primitiveDouble;
  private float primitiveFloat;
  private int primitiveInt;
  private long primitiveLong;
  private short primitiveShort;

  private Date dateObject;
  private LocalDateTime localDateTimeObject;

  private Integer integerObjectWithoutGetter;
  private Integer integerObjectWithoutSetter;

  public Integer getIntegerObjectWithoutSetter() {
    return integerObjectWithoutSetter;
  }

  public void setIntegerObjectWithoutGetter(Integer integerObjectWithoutGetter) {
    this.integerObjectWithoutGetter = integerObjectWithoutGetter;
  }

  public Boolean getBooleanObject() {
    return booleanObject;
  }

  public void setBooleanObject(Boolean booleanObject) {
    this.booleanObject = booleanObject;
  }

  public Byte getByteObject() {
    return byteObject;
  }

  public void setByteObject(Byte byteObject) {
    this.byteObject = byteObject;
  }

  public Character getCharacterObject() {
    return characterObject;
  }

  public void setCharacterObject(Character characterObject) {
    this.characterObject = characterObject;
  }

  public Double getDoubleObject() {
    return doubleObject;
  }

  public void setDoubleObject(Double doubleObject) {
    this.doubleObject = doubleObject;
  }

  public Float getFloatObject() {
    return floatObject;
  }

  public void setFloatObject(Float floatObject) {
    this.floatObject = floatObject;
  }

  public Integer getIntObject() {
    return intObject;
  }

  public void setIntObject(Integer intObject) {
    this.intObject = intObject;
  }

  public Long getLongObject() {
    return longObject;
  }

  public void setLongObject(Long longObject) {
    this.longObject = longObject;
  }

  public Short getShortObject() {
    return shortObject;
  }

  public void setShortObject(Short shortObject) {
    this.shortObject = shortObject;
  }

  public boolean isPrimitiveBoolean() {
    return primitiveBoolean;
  }

  public void setPrimitiveBoolean(boolean primitiveBoolean) {
    this.primitiveBoolean = primitiveBoolean;
  }

  public byte getPrimitiveByte() {
    return primitiveByte;
  }

  public void setPrimitiveByte(byte primitiveByte) {
    this.primitiveByte = primitiveByte;
  }

  public char getPrimitiveCharacter() {
    return primitiveCharacter;
  }

  public void setPrimitiveCharacter(char primitiveCharacter) {
    this.primitiveCharacter = primitiveCharacter;
  }

  public double getPrimitiveDouble() {
    return primitiveDouble;
  }

  public void setPrimitiveDouble(double primitiveDouble) {
    this.primitiveDouble = primitiveDouble;
  }

  public float getPrimitiveFloat() {
    return primitiveFloat;
  }

  public void setPrimitiveFloat(float primitiveFloat) {
    this.primitiveFloat = primitiveFloat;
  }

  public int getPrimitiveInt() {
    return primitiveInt;
  }

  public void setPrimitiveInt(int primitiveInt) {
    this.primitiveInt = primitiveInt;
  }

  public long getPrimitiveLong() {
    return primitiveLong;
  }

  public void setPrimitiveLong(long primitiveLong) {
    this.primitiveLong = primitiveLong;
  }

  public short getPrimitiveShort() {
    return primitiveShort;
  }

  public void setPrimitiveShort(short primitiveShort) {
    this.primitiveShort = primitiveShort;
  }

  public Date getDateObject() {
    return dateObject;
  }

  public void setDateObject(Date dateObject) {
    this.dateObject = dateObject;
  }

  public LocalDateTime getLocalDateTimeObject() {
    return localDateTimeObject;
  }

  public void setLocalDateTimeObject(LocalDateTime localDateTimeObject) {
    this.localDateTimeObject = localDateTimeObject;
  }
}
