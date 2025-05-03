## Git and Version Control Basics

- Git is a Version Control System (VCS) that helps track changes in code
- It's one of several version control clients available, with SVN being another example

## Key Components

- Repository - Where code is stored online
- Working Directory - Local development environment (offline)
- Staging Area - Intermediate area for preparing commits (offline)

## Example Git Workflow

Here's an example of a basic Git workflow for a portfolio project:

1. Create initial HTML file and commit: `git commit -m "Initial commit"`
2. Add new features (like a skills section) and commit: `git commit -m "Add skill section"`

To make these improvements to your page, please select the content you'd like to replace and then ask AI to help edit through the menu.

## Git essential Commands

- git init: Initialize empty git repo on local without adding any remote
- git clone <Repo link>
- git add <filename>
- git commit -m “<message>”  , Here -m means message
- git push
- git pull: git pull origin , git pull feature-A
- git branch feature-A: create a new Branch with given name
- git checkout Feature-A: checkout to newly created branch

Remote: Location where we store our repository

## Branch types

1. Feature Branch
2. Hotfix Branch
3. Release/Main Branch

Branch Rebase: Putting our commits on top of incoming changes