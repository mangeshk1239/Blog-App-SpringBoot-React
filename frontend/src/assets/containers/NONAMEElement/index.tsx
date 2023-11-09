import * as React from "react";

export default function NONAMEElement(): JSX.Element {

    React.useEffect(() => {
        idk(window.location.pathname.split("/user/")[1]);
    }, []);
    return (
        <>ZXC</>
    )
    async function idk(user_id): Promise<void> {
        console.log("user_id", user_id);
        await fetch(`/api/user/${user_id}`);
    }
}