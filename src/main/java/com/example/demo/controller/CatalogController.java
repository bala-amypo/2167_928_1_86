@PostMapping("/crops")
public ResponseEntity<?> addCrop(@RequestBody CropRequest req, Authentication auth) {
    boolean isAdmin = auth.getAuthorities().stream()
        .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
    
    if (!isAdmin) {
        return ResponseEntity.status(403).build();
    }
    
    Crop crop = Crop.builder()
        .name(req.getName())
        .suitablePHMin(req.getSuitablePHMin())
        .suitablePHMax(req.getSuitablePHMax())
        .requiredWater(req.getRequiredWater())
        .season(req.getSeason())
        .build();
        
    return ResponseEntity.ok(catalogService.addCrop(crop));
}