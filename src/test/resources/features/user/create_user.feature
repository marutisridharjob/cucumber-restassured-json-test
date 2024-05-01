@feature_user @feature_create_user
Feature: Create User Test

  @smoke @verify_user_created
  Scenario: User created successfully
    When create user by name is valid
    Then verify user created