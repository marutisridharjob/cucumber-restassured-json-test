@feature_user @feature_update_user
Feature: Update User Test

  Background:
    Given create user

  @smoke @verify_user_updated
  Scenario: User updated successfully
    When update user name is valid
    Then verify user updated