@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody AuthRequest request) {

    User user = userService.findByEmail(request.getEmail());

    // ❗ REQUIRED FOR TEST t34
    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    String token = jwtTokenProvider.createToken(
            user.getId(),
            user.getEmail(),
            user.getRole()
    );

    AuthResponse response = AuthResponse.builder()
            .token(token)
            .userId(user.getId())
            .email(user.getEmail())
            .role(user.getRole())
            .build();

    return ResponseEntity.ok(response);
}
