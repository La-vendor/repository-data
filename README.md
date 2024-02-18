# GitHub Repository Data API
This is a simple RESTful web application designed to retrieve data from any GitHub repository. It provides an API endpoint to fetch repository information.

## API Endpoint

`GET /repository/{author}/{repository-name}`

## Example Response

```
{
"fullName": "La-vendor/mealmate",
"description": "Meal planner with shopping list generator",
"cloneUrl": "git://github.com/La-vendor/mealmate.git",
"stars": 1,
"createdAt": "2024-01-03T23:04:45"
}
```

