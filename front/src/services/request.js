const apiURL = import.meta.env.VITE_TMDB_API_URL;
function parseData(data) {
    const formData = new FormData();
    for (let [key, value] of Object.entries(data)) {
        formData.append(key, value);
    }
    return formData;
}

function request(url, data = false, method = "GET", type = "FORM_DATA", headers = {}) {
    return new Promise(async (resolve, reject) => {
        const options = {
            method,
            headers: {
                ...headers,
            },
        };
        if (data && (method === "POST" || method === "PUT" || method === "DELETE")) {
            options.body = type === "JSON" ? JSON.stringify(data) : parseData(data);
            if (type === "JSON") {
                options.headers["Content-Type"] = "application/json";
            }
        }
        const res = await fetch(apiURL + url, options);
        const result = await res.json();
        if (res.ok) {
            resolve(result);
        } else {
            reject(result);
        }
    });
}
export const post = (url, data) => request(url, data, "POST");
export const postJSON = (url, data) => request(url, data, "POST", "JSON");
export const get = (url, headers) => request(url, headers);
export const deleteJSON = (url, id, headers) => request(url, id, "DELETE", "JSON", headers);
