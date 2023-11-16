import * as React from "react";

export default function BlogElement(): JSX.Element {
    React.useEffect(() => {
        handleFetchBlogs();
    }, []);

    return (
        <>
            hiiiii
        </>
    )

    async function handleFetchBlogs() {
        try {
            const response = await fetch("/api/blogs/fetch").then(response => response.json());
            console.log("response", response);
        } catch (error) {
            console.log("ERROR", error);
        }
    }
}