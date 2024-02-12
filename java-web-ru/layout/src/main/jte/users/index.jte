@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    @if(page.getUsers().isEmpty())
        <p>No users exists</p>
    @else
        <ul>
            @for(var user : page.getUsers())
                <li>
                    <a href="/users/${user.getId()}"> ${user.getFirstName()} ${user.getLastName()}</a>
                </li>
            @endfor
        </ul>
    @endif
`)