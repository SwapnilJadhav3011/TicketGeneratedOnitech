package com.example.onitoTech.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class TambolaTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_id")
    private List<TambolaRow> rows;

   

    public TambolaTicket() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

	public TambolaTicket(Long id, List<TambolaRow> rows) {
		super();
		this.id = id;
		this.rows = rows;
	}



	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TambolaRow> getRows() {
        return rows;
    }

    public void setRows(List<TambolaRow> rows) {
        this.rows = rows;
    }
}

