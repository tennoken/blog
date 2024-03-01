import { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

export default function BlogDetail() {
    const { blogId } = useParams();
    const [item, setItem] = useState([]);

    useEffect(() => {
        axios
            .get(`http://localhost:8080/blog/${blogId}`)
            .then((json) => setItem(json))
            .catch((e) => console.log(e));
    }, []);

    if (item.length === 0) return <div>'로딩중 ...'</div>;

    const { title, content, updatedAt } = item.data;

    return (
        <div>
            <h1>Detail page {blogId}</h1>
            <div>
                <h2>{title}</h2>
                <p>{content}</p>
                <p>{updatedAt}</p>
            </div>
        </div>
    );
}
