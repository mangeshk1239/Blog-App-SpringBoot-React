import * as React from "react";
import { IBlog } from "./interfaces";

export default function BlogElement(): JSX.Element {
    React.useEffect(() => {
        handleFetchBlogs();
    }, []);

    const [getBlogs, setBlogs] = React.useState<Array<IBlog>>([]);

    return (
        <>
            {
                getBlogs.length > 0 ?
                    getBlogs.map((blog) => {
                        return <>
                            {blog.title}
                            <br />
                            {blog.description}
                            <br />
                            <br />
                            <br />
                        </>
                    }) :
                    <>NO BLOGS...</>
            }
        </>
    )

    async function handleFetchBlogs() {
        try {
            const response = await fetch("/api/blogs/fetch").then(response => response.json());
            if (response.success) setBlogs(response.data);
        } catch (error) {
            console.log("ERROR", error);
        }
    }
}