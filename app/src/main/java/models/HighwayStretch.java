package models;

import com.modesteam.pardal.ComparableCategory;

import annotations.OrderBy;
import helpers.Condition;
import helpers.GenericPersistence;

import java.sql.SQLException;
import java.util.ArrayList;

import libraries.NotNullableException;
import annotations.Column;
import annotations.Entity;
import annotations.HasMany;
import annotations.HasOne;
import annotations.ManyRelations;
import annotations.OneRelations;

@Entity(table="highway_stretch", primaryKey="id")
@OneRelations({
	@HasOne(entity=City.class, reference="idCity", belongs=true)
})
@ManyRelations({
	@HasMany(entity=Tickets.class, foreignKey="idHighwayStretch")
})
@OrderBy(field = "number")
public class HighwayStretch implements ComparableCategory{

	@Column(name="_id", nullable=false)
	private int id;
	
	private String number;
	
	private int kilometer;

	@Column(name="total_tickets", nullable=true)
	private int totalTickets;
	@Column(name="average_exceded", nullable=true)
	private Double averageExceded;
	@Column(name="maximum_measured_velocity", nullable=true)
	private Double maximumMeasuredVelocity;
	
	@Column(name="id_city", nullable = false)
	private int idCity;

	public int getId() {
		return id;
	}

	public HighwayStretch() {
		super();
	}
	
	public HighwayStretch(int id) {
		super();
		this.id = id;
	}
	
	public HighwayStretch(String number, int kilometer, int idCity) {
		super();
		this.number = number;
		this.kilometer = kilometer;
		this.idCity = idCity;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getKilometer() {
		return kilometer;
	}

	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

    public int getTotalTickets() {
        return totalTickets;
    }
    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }
    public Double getAverageExceded() {
        return averageExceded;
    }
    public void setAverageExceded(Double averageExceded) {
        this.averageExceded = averageExceded;
    }
    public Double getMaximumMeasuredVelocity() {
        return maximumMeasuredVelocity;
    }
    public void setMaximumMeasuredVelocity(Double maximumMeasuredVelocity) {
        this.maximumMeasuredVelocity = maximumMeasuredVelocity;
    }
	
	public boolean save() throws ClassNotFoundException, SQLException, NotNullableException{
		GenericPersistence gP = new GenericPersistence();
		boolean result = gP.insertBean(this);
		this.setId(HighwayStretch.last().getId());
		return result;
	}
	
	public static HighwayStretch get(int id) throws ClassNotFoundException, SQLException{
		GenericPersistence gP = new GenericPersistence();
		return (HighwayStretch) gP.selectBean(new HighwayStretch(id));
	}
	
	public static ArrayList<HighwayStretch> getAll() throws ClassNotFoundException, SQLException{
		GenericPersistence gP = new GenericPersistence();
		ArrayList<HighwayStretch> stretches = new ArrayList<HighwayStretch>();
		for (Object bean : gP.selectAllBeans(new HighwayStretch())) {
			stretches.add((HighwayStretch)bean);
		}
		return stretches;
	}
	
	public static int count() throws ClassNotFoundException, SQLException {
		GenericPersistence gDB = new GenericPersistence();
		return gDB.countBean(new HighwayStretch());
	}
	
	public static HighwayStretch first() throws ClassNotFoundException, SQLException{
		GenericPersistence gP = new GenericPersistence();
		return (HighwayStretch) gP.firstOrLastBean(new HighwayStretch() , false);
	}
	
	public static HighwayStretch last() throws ClassNotFoundException, SQLException{
		GenericPersistence gP = new GenericPersistence();
		return (HighwayStretch) gP.firstOrLastBean(new HighwayStretch() , true);
	}
	
	public static ArrayList<HighwayStretch> getWhere(Condition condition) throws ClassNotFoundException, SQLException{
		GenericPersistence gP = new GenericPersistence();
		ArrayList<HighwayStretch> stretches = new ArrayList<HighwayStretch>();
		for (Object bean : gP.selectWhere(new HighwayStretch(), condition)) {
			stretches.add((HighwayStretch)bean);
		}
		return stretches;
	}

	public boolean delete() throws ClassNotFoundException, SQLException {
		GenericPersistence gP = new GenericPersistence();
		return gP.deleteBean(this);
	}

	public City getCity() throws ClassNotFoundException, SQLException{
		GenericPersistence gP = new GenericPersistence();
		return (City) gP.selectOne(this, new City());
	}
	
	public ArrayList<Tickets> getTickets() throws ClassNotFoundException, SQLException{
		GenericPersistence gP = new GenericPersistence();
		ArrayList<Tickets> beans = new ArrayList<Tickets>();
		for (Object bean : gP.selectMany(this, new Tickets())) {
			beans.add((Tickets)bean);
		}
		return beans;
	}

	@Override
	public String toString() {
		return "BR " + number
				+ " - Km " + kilometer;
	}
}
