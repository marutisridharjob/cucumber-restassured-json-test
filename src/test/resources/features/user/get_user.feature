@feature_user @feature_get_user
Feature: Get User Test

  Background:
    Given create user

  @smoke @verify_user_listed
  Scenario: User listed successfully
    When get user by id
    Then verify user listed