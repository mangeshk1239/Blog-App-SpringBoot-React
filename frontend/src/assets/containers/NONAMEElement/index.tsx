import * as React from "react";

export default function NONAMEElement(): JSX.Element {

    React.useEffect(() => {
        idk(Number(window.location.pathname.split("/blogger/")[1]));
    }, []);
    return (
        <>
            <button>Create Blog</button>
        </>
    )
    async function idk(id: number): Promise<void> {
        await fetch(`/api/blogger/${id}`);
    }
}