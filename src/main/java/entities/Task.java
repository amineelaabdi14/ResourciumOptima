package entities;
import enums.TaskPriority;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description",columnDefinition="Text")
    private String description;

    @Column(name = "priority")
    private TaskPriority priority;


    @ManyToOne
    @JoinColumn(name = "Employee_id")
    private Employee assignedEquipment;
}

