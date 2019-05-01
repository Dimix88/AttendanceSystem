package com.dimitri.domain;

import java.util.Objects;

public class Room implements Comparable<Room>{
    String roomCode;
    String roomType;
    String bldgCode;

    public Room(){}

    public Room(Builder builder){
        this.roomCode = builder.roomCode;
        this.roomType = builder.roomType;
        this.bldgCode = builder.bldgCode;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getBldgCode() {
        return bldgCode;
    }

    public static class Builder{
        String roomCode;
        String roomType;
        String bldgCode;

        public Builder roomCode(String roomCode){
            this.roomCode = roomCode;
            return this;
        }
        public Builder roomType(String roomType){
            this.roomType = roomType;
            return this;
        }
        public Builder bldgCode(String bldgCode){
            this.bldgCode = bldgCode;
            return this;
        }
        public Builder copy(Room room){
            this.roomCode = room.roomCode;
            this.roomType = room.roomType;
            this.bldgCode = room.bldgCode;

            return this;
        }
        public Room build(){return new Room(this);}
    }

    @Override
    public int compareTo(Room o) {
        return this.roomCode.compareTo(o.roomCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomCode.equals(room.roomCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomCode);
    }
}
