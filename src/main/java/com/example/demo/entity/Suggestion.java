@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String suggestedCrops;
    private String suggestedFertilizers;
    private java.time.LocalDateTime createdAt;

    @ManyToOne
    private Farm farm;

    @PrePersist
    public void prePersist() {
        this.createdAt = java.time.LocalDateTime.now();
    }
}