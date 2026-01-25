# Vanemarendaja Team 34

## Team members
- Anneli Peep - 
- Kevin Kiviväli - kivivali
- Peeter Lond - PeeterLond
- Robert Koppel - backlooper525
- Marti Taru - martar2277

## Team workflow

### Issue Lifecycle

**Backlog** → Ideas and tasks waiting to be defined
- Initial issue creation
- High-level description, may lack details

**Ready for Sprint** → Fully defined and ready to work on
- Issue clearly written with acceptance criteria
- All requirements and context documented
- Can be picked up by any team member

**Ready** → Assigned and actively being worked on
- Issue assigned to a developer
- Work in progress

**In Progress** → Active development
- Code being written
- Feature branch created from main

**In Review** → Pull request submitted
- PR created and linked to issue (`Closes #X`)
- Waiting for code review
- If changes requested → move back to In Progress
- If approved → move to Done

**Done** → Completed and merged
- PR approved and merged to main
- Issue closed automatically
- Feature branch deleted

### Git Workflow

1. Create feature branch from main: `git checkout -b feature-name`
2. Make changes and commit regularly
3. Push branch: `git push origin feature-name`
4. Create PR linking to issue
5. Request review from team member
6. Address review comments if needed
7. After approval, merge to main
8. Delete feature branch

 
## Definition of Done

A task is considered "done" when ALL of the following are complete:

### Code & Testing
- [ ] Code is written and works as expected
- [ ] Edge cases tested (invalid inputs, error states)
- [ ] No TypeScript errors or console warnings
- [ ] Tested on different screen sizes (if UI change)

### Review & Integration
- [ ] Pull request created with clear description
- [ ] Code reviewed and approved by at least one team member
- [ ] All review comments addressed
- [ ] Code merged to main branch with no conflicts

### Documentation & Cleanup
- [ ] README or relevant docs updated if needed
- [ ] Comments added for complex logic
- [ ] GitHub issue moved to "Done" column
- [ ] Feature branch deleted