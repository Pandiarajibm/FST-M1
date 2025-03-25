@activity6
Feature: To test input with DataTables

@TasksDataTable
Scenario: Testing the To-Do app
  Given User user is on the To-Do list page
  When user adds the following tasks
    | task1 |
    | task2 |
    | task3 |
  Then they can see the tasks added to the list