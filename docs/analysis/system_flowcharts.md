# SYSTEM FLOWCHARTS AND PROCESSES

## 1. Authentication Process (Login Flow)
This flowchart describes how the system handles user authentication and role-based redirection.

```mermaid
flowchart TD
    Start([Start]) --> Input[/Input Username & Password/]
    Input --> CheckEmpty{Is Data Empty?}
    
    CheckEmpty -- Yes --> Error1[Error: Missing Input]
    Error1 --> Input
    
    CheckEmpty -- No --> QueryDB[(Query User Database)]
    QueryDB --> CheckValid{Credentials Valid?}
    
    CheckValid -- No --> Error2[Error: Invalid Account]
    Error2 --> Input
    
    CheckValid -- Yes --> CheckRole{Check User Role}
    
    CheckRole -- Admin --> RedirectAdmin[Redirect: Admin Dashboard]
    CheckRole -- Customer --> RedirectHome[Redirect: Home Page]
    
    RedirectAdmin --> End([End])
    RedirectHome --> End