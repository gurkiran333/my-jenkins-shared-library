def call(String image, String tag) {

    echo "Starting Flask application deployment"
    echo "Image: ${image}:${tag}"

    sh """
        docker rm -f flaskapp || true

        docker run -d \
        --name flaskapp \
        -p 5000:5000 \
        ${image}:${tag}
    """

    echo "Flask application deployed successfully"
}
