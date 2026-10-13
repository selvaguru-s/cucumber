
Feature: Practice Form

Background:
Given user opens the practice form

Scenario: Fill practice form using DataTable

```
When user enters the following details
  | India |
  | Mr. |
  | Selva |
  | Guru |
  | 1995-05-20 |
  | 01/06/2021 |
  | selva@example.com |
  | +91 |
  | 9876543210 |
  | Email |

And user clicks submit
