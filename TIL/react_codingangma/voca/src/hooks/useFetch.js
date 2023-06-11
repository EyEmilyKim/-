import { useEffect, useState } from "react";

export default function useFetch(url){
    const [data, setData] = useState([]);

    useEffect(()=>{
        fetch(url)
        .then(res=>{
          return res.json();
        }) 
        .then(data=>{
          setData(data);
        })
        .catch(error=>{
          console.log(`useFetch() 에러 발생 : ${error}`);
          console.error(error);
          
        })
      }, [url]);

      return data;
}
