import { useEffect, useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';

export default function BlogOverview() {
    const [item, setItem] = useState([]);
    const navigator = useNavigate();
    const goToDetail = (blogId) => navigator(`/blog/${blogId}`);

    useEffect(() => {
        axios
            .get('http://localhost:8080/blog/list')
            .then((json) => setItem(json))
            .catch((e) => console.log(e));
    }, []);

    if (item.length === 0) return '로딩중';

    return (
        <section className="flex justify-center">
            <div>
                {item.data.map((i) => (
                    <div className="my-10">
                        <h2
                            className="text-5xl mb-1 cursor-pointer"
                            onClick={() => goToDetail(i.id)}
                        >
                            {i.title}
                        </h2>
                        <p>{i.content}</p>
                        <div>{i.createdAt}</div>
                    </div>
                ))}
            </div>
        </section>
    );
}
