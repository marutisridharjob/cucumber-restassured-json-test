@feature_user @feature_delete_user
Feature: Delete User Test

  Background:
    Given create user

  @smoke @verify_user_deleted
  Scenario: User deleted successfully
    When delete user
    Then verify user deleted