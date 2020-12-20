package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextJobId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // constructors

    public Job() {
        id = nextJobId;
        nextJobId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // equals & hashcode

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // isAvailable method for toString
    public String isAvailable(JobField infoToPrint) {
        return !infoToPrint.getValue().equals("") ? infoToPrint.getValue() : "Data not available";
    }

    // toString

    @Override
    public String toString() {
        if (this.getName() == null && this.getEmployer() == null && this.getLocation() == null && this.getPositionType() == null && this.getCoreCompetency() == null) {
            return "OOPS! This job does not seem to exist.";
        }
        return "\nID: " +
                this.getId() +
                "\nName: " +
                (!this.getName().equals("") ? this.getName() : "Data not available") +
                "\nEmployer: " +
                isAvailable(this.getEmployer()) +
                "\nLocation: " +
                isAvailable(this.getLocation()) +
                "\nPosition Type: " +
                isAvailable(this.getPositionType()) +
                "\nCore Competency: " +
                isAvailable(this.getCoreCompetency()) +
                "\n";
    }

    // getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
}
