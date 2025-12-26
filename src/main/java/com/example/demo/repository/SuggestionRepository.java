public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {
    List<Suggestion> findByFarmId(Long farmId);
}
